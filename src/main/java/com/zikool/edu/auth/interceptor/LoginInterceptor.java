package com.zikool.edu.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zikool.edu.frame.common.GlobalConfigure;
import com.zikool.edu.frame.common.ThreadLocalWrapper;
import com.zikool.edu.frame.common.UserContext;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private PathMatcher pathMatcher = new AntPathMatcher();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getServletPath();
		String contextPath = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+contextPath+"/";
		
		request.setAttribute("path", contextPath);
		request.setAttribute("basePath", basePath);
		
		Subject subject = SecurityUtils.getSubject();
		if(!subject.isAuthenticated()){
			for (String noInter : GlobalConfigure.NO_INTERCEPTOR_URL) {
				if (pathMatcher.match(noInter, requestUrl)) {
					return true;
				}
			}
			
			response.sendRedirect(contextPath+"/login.do");
			return false;
		}
		UserContext userContext = (UserContext) subject.getSession().getAttribute(ThreadLocalWrapper.USER_CONTEXT_KEY);
		ThreadLocalWrapper.bind(userContext);
		return super.preHandle(request, response, handler);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ThreadLocalWrapper.remove();
		super.afterCompletion(request, response, handler, ex);
	}

}
