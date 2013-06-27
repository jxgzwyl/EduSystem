package com.zikool.edu.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zikool.edu.auth.entity.Privilege;
import com.zikool.edu.auth.service.IPrivilegeService;
import com.zikool.edu.frame.common.GlobalConfigure;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	@Qualifier("iPrivilegeService")
	private IPrivilegeService privilegeService;
	
	@Autowired
	@Qualifier("resourcesEhCache")
	private Ehcache resourcesEhCache;
	
	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getServletPath();
		for(String url : GlobalConfigure.NO_INTERCEPTOR_URL){
			if(requestUrl.equalsIgnoreCase(url)){
				return true;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append(GlobalConfigure.URI_DEFINITION_KEY).append(":").append(requestUrl);
		Element uriElement = this.resourcesEhCache.get(builder.toString());
		if(uriElement == null){
			Privilege privilege = this.privilegeService.findByUri(requestUrl);
			//如果没有找到相应的权限,则默认可以访问.
			if(privilege == null){
				return true;
			}
			
			String optName = this.privilegeService.queryPrivilegeOpt(requestUrl);
			
			uriElement = new Element(builder.toString(), optName);
			this.resourcesEhCache.put(uriElement);
		}
		
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isPermitted((String)uriElement.getObjectValue())){
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath+"/html/403.htm");
			return false;
		}
		return super.preHandle(request, response, handler);
	}

}
