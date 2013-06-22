package com.zikool.edu.config;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-6-2
 * Time: 下午5:05
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    public static final int ADD = 1000;
    public static final int EDIT = 1001;
    public static final int DELETE = 1002;
    public static final String CURRENT_USER="CURRENT_USER";
    public static final String INDEX_PAGE="/login.jsp";
    public final static String[] NO_INTERCEPTOR_URL = new String[]{"/home.do","/login.do","/getJson.do","/getTree.do","/getForm.do","/getTreePanel.do"};

}
