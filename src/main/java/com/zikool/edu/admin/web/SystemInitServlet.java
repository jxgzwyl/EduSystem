package com.zikool.edu.admin.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午5:11
 * To change this template use File | Settings | File Templates.
 */
public class SystemInitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
        initSystemPrivilege();
        initSystemRole();
        initAdmin();
    }




    private void initSystemPrivilege() {

    }
    private void initSystemRole() {
    }

    private void initAdmin() {
    }
}

