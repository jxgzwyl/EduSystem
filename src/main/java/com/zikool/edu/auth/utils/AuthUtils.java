package com.zikool.edu.auth.utils;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import com.zikool.edu.config.Config;

public class AuthUtils {

	private static PathMatcher pathMatcher = new AntPathMatcher();
	/**
	 * 
	 * @param url
	 *            需要访问的URL
	 * @param uas
	 *            所拥有的权限code
	 * @return
	 */
	public static boolean isAuth(String url, Set<String> uas) {
		int firstQuestionMarkIndex = url.indexOf("?");

		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		for (String noInter : Config.NO_INTERCEPTOR_URL) {

			if (pathMatcher.match(noInter, url)) {
				return true;
			}
		}

		for (String ua : uas) {
			if (StringUtils.equals(url, ua)) {
				return true;
			}
		}
		return false;
	}

}
