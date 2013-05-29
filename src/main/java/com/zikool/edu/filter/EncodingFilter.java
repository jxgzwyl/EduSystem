package com.zikool.edu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        final HttpServletRequest mHttpServletRequest = (HttpServletRequest) request;
        HttpServletResponse mHttpServletResponse = (HttpServletResponse) response;

        mHttpServletRequest.setCharacterEncoding(mEncoding);
        mHttpServletResponse.setCharacterEncoding(mEncoding);
        mHttpServletResponse.setContentType("text/html;charset=" + mEncoding);
        filterChain.doFilter((HttpServletRequest) Proxy.newProxyInstance(EncodingFilter.class.getClassLoader(), mHttpServletRequest.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if ("getParameter".equalsIgnoreCase(method.getName()) == false) {
                    return method.invoke(mHttpServletRequest, args);
                } else {
                    if (mHttpServletRequest.getMethod().toLowerCase().equals("get")) {
                        String value = mHttpServletRequest.getParameter((String) args[0]);
                        return new String(value.getBytes("iso8859-1"), mEncoding);
                    } else {
                        return method.invoke(mHttpServletRequest, args);
                    }
                }
            }
        }), mHttpServletResponse);
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

        mEncoding = null;
    }
}
