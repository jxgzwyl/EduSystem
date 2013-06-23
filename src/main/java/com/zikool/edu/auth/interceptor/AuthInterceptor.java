package com.zikool.edu.auth.interceptor;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.auth.utils.AuthUtils;
import com.zikool.edu.config.Config;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private PathMatcher pathMatcher = new AntPathMatcher();
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String url = request.getServletPath();

		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		for (String noInter : Config.NO_INTERCEPTOR_URL) {
			if (pathMatcher.match(noInter, url)) {
				return true;
			}
		}

		TbUser user = (TbUser) request.getSession()
				.getAttribute(Config.CURRENT_USER);
		
		//获取用户的所有权限
		Set<String> uas = user.getUrls();
		
		if(!AuthUtils.isAuth(url, uas)) {
			String contextPath = request.getContextPath();
			//无操作权限页面OR首页？
			response.sendRedirect(contextPath + Config.INDEX_PAGE);
			return false;
		} else {
			return true;
		}
	}

}
