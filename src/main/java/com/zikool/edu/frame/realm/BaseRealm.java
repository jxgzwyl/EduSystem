package com.zikool.edu.frame.realm;

import java.util.ArrayList;
import java.util.List;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zikool.edu.auth.entity.RolePrivilege;
import com.zikool.edu.auth.service.IRoleService;
import com.zikool.edu.frame.common.GlobalConfigure;
import com.zikool.edu.frame.common.ThreadLocalWrapper;
import com.zikool.edu.frame.common.UserContext;
import com.zikool.edu.user.entity.User;
import com.zikool.edu.user.service.IUserService;

public class BaseRealm extends AuthorizingRealm {
	
	@Autowired
	@Qualifier("iUserService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("iRoleService")
	private IRoleService roleService;
	
	@Autowired
	@Qualifier("rolesEhCache")
	private Ehcache rolesEhCache;
	
	@Autowired
	@Qualifier("resourcesEhCache")
	private Ehcache resourcesEhCache;
	
	private static final Logger logger = LoggerFactory.getLogger(BaseRealm.class);

	/*
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken _authcToken = (UsernamePasswordToken) authcToken;
		String identityCard = _authcToken.getUsername();
        if (StringUtils.isEmpty(identityCard)) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }
        User currentUser = this.userService.findByIdentityCard(identityCard);
        if(null == currentUser){
        	throw new UnknownAccountException();
        }
        String password = currentUser.getPassword().toLowerCase();
        return new SimpleAuthenticationInfo(identityCard, password, getName());
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		Subject subject = SecurityUtils.getSubject();
		UserContext userContext = (UserContext) subject.getSession().getAttribute(ThreadLocalWrapper.USER_CONTEXT_KEY);
		User currentUser = userContext.getCurrentUser();
		
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		StringBuilder builder = new StringBuilder();
		builder.append("_").append(currentUser.getUserId()).append(":opt:").append(currentUser.getUserName()).append("_");
		ThreadLocalWrapper.put(GlobalConfigure.PERMISSION_OPT_DEFINITION_KEY, builder.toString());
		Element resourcesElement = resourcesEhCache.get(builder.toString());
		if(resourcesElement == null){
			//获取用户可操作权限
			List<RolePrivilege> rolePrivileges = this.roleService.findOperationByIdUser(currentUser.getUserId());
			List<String> operationStrs = new ArrayList<String>();
			for(RolePrivilege rolePermission : rolePrivileges){
				if(operationStrs.contains(rolePermission.getOperation())){
					continue;
				}
				operationStrs.add(rolePermission.getOperation());
			}
			resourcesElement = new net.sf.ehcache.Element(builder.toString(), operationStrs);
			resourcesEhCache.put(resourcesElement);
		}
		logger.info("用户可操作权限:"+resourcesElement.getObjectValue());
		info.addStringPermissions((List<String>)resourcesElement.getObjectValue());
		return info;
	}

}
