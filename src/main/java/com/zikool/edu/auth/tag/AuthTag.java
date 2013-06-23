package com.zikool.edu.auth.tag;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.zikool.edu.auth.bean.TbUser;
import com.zikool.edu.auth.utils.AuthUtils;
import com.zikool.edu.config.Config;

public class AuthTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2222008674060730766L;

	static Logger log = LoggerFactory.getLogger(AuthTag.class);

	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int doStartTag() throws JspException {
		HttpSession session = this.pageContext.getSession();
		JspWriter out = this.pageContext.getOut();
		try {
			
			if (session == null
					|| session.getAttribute(Config.CURRENT_USER) == null) {
				out.print(false);
			} else {
				TbUser user = (TbUser) session
						.getAttribute(Config.CURRENT_USER);
				
				Set<String> uas = user.getUrls();
				
				if(AuthUtils.isAuth(url, uas)) {
					out.print(true);
				} else {
					out.print(false);
				}
			}
		} catch (IOException e) {
			log.error("AuthTag doStartTag, url : " + url, e);
		}
		return super.doStartTag();
	}

	public void release() {
		super.release();
		this.url = null;
	}
}