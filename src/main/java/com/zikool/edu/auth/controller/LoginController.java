package com.zikool.edu.auth.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zikool.edu.auth.entity.Privilege;
import com.zikool.edu.auth.service.IPrivilegeService;
import com.zikool.edu.frame.common.GlobalConfigure;
import com.zikool.edu.frame.common.JSONResponse;
import com.zikool.edu.frame.common.ThreadLocalWrapper;
import com.zikool.edu.frame.common.UserContext;
import com.zikool.edu.frame.utils.CookieUtils;
import com.zikool.edu.user.entity.User;
import com.zikool.edu.user.service.IUserService;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("iUserService")
	private IUserService userService;
	
	@Autowired
	@Qualifier("iPrivilegeService")
	private IPrivilegeService privilegeService;
	
	@Autowired
	@Qualifier("resourcesEhCache")
	private Ehcache resourcesEhCache;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login.do")
	public String login(Model model){
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()){
			return "redirect:/home.do";
		}
		return "auth/login";
	}
	
	@RequestMapping(value="/dologin.do")
	public @ResponseBody JSONResponse doLogin(HttpServletRequest request, @RequestParam String identityCard, @RequestParam String password){
		JSONResponse json = new JSONResponse();
		if(StringUtils.isEmpty(identityCard)){
			json.setMsg("登录名不能为空!");
			return json;
		}
		
		if(StringUtils.isEmpty(password)){
			json.setMsg("密码不能为空!");
			return json;
		}
		
		UsernamePasswordToken token = new UsernamePasswordToken(identityCard, DigestUtils.md5Hex(password).toLowerCase());
		token.setRememberMe(true);
		try {
			Subject subject = SecurityUtils.getSubject();
			subject.login(token);
			if(!subject.isAuthenticated()){
				json.setMsg("用户验证失败!");
            	return json;
            }
			User currentUser = this.userService.findByIdentityCard(identityCard);
			UserContext userContext = new UserContext();
			userContext.setCurrentUser(currentUser);
			userContext.setAddressIp(CookieUtils.getCurrIpAddress(request));
			
			subject.getSession().setAttribute(ThreadLocalWrapper.USER_CONTEXT_KEY, userContext);
			ThreadLocalWrapper.bind(userContext);
			
			StringBuilder builder = new StringBuilder();
            builder.append("_").append(currentUser.getUserId()).append(":permission:").append(currentUser.getUserName()).append("_");
            ThreadLocalWrapper.put(GlobalConfigure.PERMISSION_DEFINITION_KEY, builder.toString());
            
            Element privilegeElement = this.resourcesEhCache.get(builder.toString());
            if(null == privilegeElement){
            	List<Privilege> privileges = this.privilegeService.queryByIdUser(currentUser.getUserId());
                privilegeElement = new Element(builder.toString(), privileges);
                resourcesEhCache.put(privilegeElement);
            }
            logger.info(builder.toString()+",可以访问的URI:"+privilegeElement.getObjectValue());
            
			json.setSuccess(true);
			json.setMsg("登录成功.");
		} catch (UnknownAccountException uae) {
        	logger.error("There is no user with username of " + token.getPrincipal());
        	json.setMsg("用户不存在,请重新输入!");
        } catch (IncorrectCredentialsException ice) {
        	logger.error("Password for account " + token.getPrincipal() + " was incorrect!");
        	json.setMsg("密码错误,请重新输入!");
        } catch (Exception ae) {
        	logger.error("Authentication Error:", ae);
        }
		return json;
	}
	
	@RequestMapping(value="/dologout.do")
	public String doLogout(HttpSession session){
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		ThreadLocalWrapper.remove();
		return "redirect:/login.do";
	}
}
