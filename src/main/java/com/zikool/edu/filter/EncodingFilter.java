package com.zikool.edu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-5-20
 * Time: 下午10:27
 * To change this template use File | Settings | File Templates.
 */
public class EncodingFilter implements Filter {

    private String mEncoding;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        mEncoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        request.setCharacterEncoding(mEncoding);
        response.setCharacterEncoding(mEncoding);

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        mEncoding = null;
    }
}
