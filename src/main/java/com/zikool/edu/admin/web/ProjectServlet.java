package com.zikool.edu.admin.web;

import com.zikool.edu.config.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-6-2
 * Time: 下午5:07
 * To change this template use File | Settings | File Templates.
 */
public class ProjectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        int op = Integer.parseInt(req.getParameter("op"));

        switch (op) {
            case Config.ADD :
                break;
            case Config.EDIT :
                break;
            case Config.DELETE :
                break;
        }

    }
}
