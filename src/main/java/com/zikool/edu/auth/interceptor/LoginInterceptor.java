package com.zikool.edu.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.config.Config;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private PathMatcher pathMatcher = new AntPathMatcher();

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String url = request.getServletPath();

		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		String contextPath = request.getContextPath();
		TbUser user = (TbUser) request.getSession()
				.getAttribute(Config.CURRENT_USER);
		if (user == null) {
			
			for (String noInter : Config.NO_INTERCEPTOR_URL) {
				if (pathMatcher.match(noInter, url)) {
					return true;
				}
			}
			
			response.sendRedirect(contextPath + Config.INDEX_PAGE);
			return false;
		}
		return super.preHandle(request, response, handler);
	}

}
