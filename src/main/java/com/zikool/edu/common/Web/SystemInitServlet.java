package com.zikool.edu.common.web;

import com.zikool.edu.common.privilege.Role;
import com.zikool.edu.common.privilege.SystemPrivilege;
import com.zikool.edu.common.service.PrivilegeService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-16
 * Time: 下午10:16
 * To change this template use File | Settings | File Templates.
 */
public class SystemInitServlet extends HttpServlet {
    private PrivilegeService  privilegeService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);    //To change body of overridden methods use File | Settings | File Templates.
        privilegeService = (PrivilegeService) WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getBean("privilegeService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        initSystemPrivileges();
        initSystemRoles();
        initSystemSuperAdmin();
    }

    private void initSystemSuperAdmin() {
    }


    private void initSystemPrivileges() {
        List<SystemPrivilege> systemPrivilegeList = new ArrayList<SystemPrivilege>();
        //项目
        SystemPrivilege menu1 = new SystemPrivilege("学员我的项目", SystemPrivilege.Type.Meun, "url", null,"我的项目");
        systemPrivilegeList.add(menu1);
        systemPrivilegeList.add(new SystemPrivilege("学员项目详细", SystemPrivilege.Type.Operation, "url", menu1,"项目详细"));
        systemPrivilegeList.add(new SystemPrivilege("学员查看相关课程", SystemPrivilege.Type.Operation, "url", menu1,"查看相关课程"));
        //公告
        SystemPrivilege menu2 = new SystemPrivilege("学员我的公告", SystemPrivilege.Type.Meun, "url", null,"我的公告");
        systemPrivilegeList.add(menu2);
        systemPrivilegeList.add(new SystemPrivilege("学员查看公告详细", SystemPrivilege.Type.Operation, "url", menu2,"查看公告"));

        SystemPrivilege menu3 = new SystemPrivilege("学员我的课程", SystemPrivilege.Type.Meun, "url", null,"我的课程");
        systemPrivilegeList.add(menu3);
        systemPrivilegeList.add(new SystemPrivilege("学员在线课堂", SystemPrivilege.Type.Operation, "url", menu3,"在线课堂"));
        systemPrivilegeList.add(new SystemPrivilege("学员我的课程作业列表", SystemPrivilege.Type.Operation, "url", menu3,"我的课程作业列表"));
        systemPrivilegeList.add(new SystemPrivilege("学员作业详细", SystemPrivilege.Type.Operation, "url", menu3,"作业详细"));
        systemPrivilegeList.add(new SystemPrivilege("学员项目论坛", SystemPrivilege.Type.Operation, "url", menu3,"项目论坛"));
        systemPrivilegeList.add(new SystemPrivilege("学员我的课程在线考试", SystemPrivilege.Type.Operation, "url", menu3,"我的课程在线考试"));
        systemPrivilegeList.add(new SystemPrivilege("学员在线课堂评价", SystemPrivilege.Type.Operation, "url", menu3,"在线课堂评价"));
        systemPrivilegeList.add(new SystemPrivilege("学员在线课堂点评", SystemPrivilege.Type.Operation, "url", menu3,"在线课堂点评"));

        SystemPrivilege menu4 = new SystemPrivilege("学员我的班级", SystemPrivilege.Type.Meun, "url", null,"我的班级");
        systemPrivilegeList.add(menu4);

        SystemPrivilege menu5 = new SystemPrivilege("学员我的基本信息", SystemPrivilege.Type.Meun, "url", null,"我的基本信息");
        systemPrivilegeList.add(menu5);

        systemPrivilegeList.add(new SystemPrivilege("学员保存我的基本信息", SystemPrivilege.Type.Operation, "url", menu5,"保存我的基本信息"));

        SystemPrivilege menu6 = new SystemPrivilege("学员我的荣誉", SystemPrivilege.Type.Meun, "url", null,"我的荣誉");
        systemPrivilegeList.add(menu6);
        systemPrivilegeList.add(new SystemPrivilege("学员打印我的荣誉", SystemPrivilege.Type.Operation, "url", menu6,"打印我的荣誉"));

        systemPrivilegeList.add(new SystemPrivilege("学员下载我的荣誉", SystemPrivilege.Type.Operation, "url", menu6,"下载我的荣誉"));

        SystemPrivilege menu7 = new SystemPrivilege("学员寻求帮助", SystemPrivilege.Type.Meun, "url", null,"寻求帮助");
        systemPrivilegeList.add(menu7);

        SystemPrivilege menu8 = new SystemPrivilege("辅导老师我的项目", SystemPrivilege.Type.Meun, "url", null,"我的项目");
        systemPrivilegeList.add(menu8);
        systemPrivilegeList.add(new SystemPrivilege("辅导老师项目详细", SystemPrivilege.Type.Operation, "url", menu8,"项目详细"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师查看相关课程", SystemPrivilege.Type.Operation, "url", menu8,"查看相关课程"));
        //公告
        SystemPrivilege menu9 = new SystemPrivilege("辅导老师我的公告", SystemPrivilege.Type.Meun, "url", null,"我的公告");
        systemPrivilegeList.add(menu9);
        systemPrivilegeList.add(new SystemPrivilege("辅导老师发布班级公告", SystemPrivilege.Type.Operation, "url", menu9,"发布班级公告"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师查看公告详细", SystemPrivilege.Type.Operation, "url", menu9,"查看公告"));

        SystemPrivilege menu10 = new SystemPrivilege("辅导老师我的课程", SystemPrivilege.Type.Meun, "url", null,"我的课程");
        systemPrivilegeList.add(menu10);
        systemPrivilegeList.add(new SystemPrivilege("辅导老师在线课堂", SystemPrivilege.Type.Operation, "url", menu10,"在线课堂"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师我的课程作业列表", SystemPrivilege.Type.Operation, "url", menu10,"我的课程作业列表"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师作业详细", SystemPrivilege.Type.Operation, "url", menu10,"作业详细"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师学员作业列表查询", SystemPrivilege.Type.Operation, "url", menu10,"查询"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师学员作业批阅", SystemPrivilege.Type.Operation, "url", menu10,"批阅"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师学员作业重新批阅", SystemPrivilege.Type.Operation, "url", menu10,"重新批阅"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师学员作业催促", SystemPrivilege.Type.Operation, "url", menu10,"催促"));

        systemPrivilegeList.add(new SystemPrivilege("辅导老师项目论坛", SystemPrivilege.Type.Operation, "url", menu10,"项目论坛"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师我的课程在线考试", SystemPrivilege.Type.Operation, "url", menu10,"我的课程在线考试"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师在线课堂评价", SystemPrivilege.Type.Operation, "url", menu10,"在线课堂评价"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师在线课堂点评", SystemPrivilege.Type.Operation, "url", menu10,"在线课堂点评"));

        SystemPrivilege menu11 = new SystemPrivilege("辅导老师我的班级", SystemPrivilege.Type.Meun, "url", null,"我的班级");
        systemPrivilegeList.add(menu11);
        systemPrivilegeList.add(new SystemPrivilege("辅导老师新增班级简报", SystemPrivilege.Type.Operation, "url", menu11,"新增班级简报"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师删除班级简报", SystemPrivilege.Type.Operation, "url", menu11,"删除班级简报"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师修改班级简报", SystemPrivilege.Type.Operation, "url", menu11,"修改班级简报"));
        systemPrivilegeList.add(new SystemPrivilege("辅导老师班级查询", SystemPrivilege.Type.Operation, "url", menu11,"班级查询"));

        SystemPrivilege menu12 = new SystemPrivilege("辅导老师我的基本信息", SystemPrivilege.Type.Meun, "url", null,"我的基本信息");
        systemPrivilegeList.add(menu12);

        systemPrivilegeList.add(new SystemPrivilege("辅导老师保存我的基本信息", SystemPrivilege.Type.Operation, "url", menu12,"保存我的基本信息"));

        SystemPrivilege menu13 = new SystemPrivilege("辅导老师我的荣誉", SystemPrivilege.Type.Meun, "url", null,"我的荣誉");
        systemPrivilegeList.add(menu13);
        systemPrivilegeList.add(new SystemPrivilege("辅导老师打印我的荣誉", SystemPrivilege.Type.Operation, "url", menu13,"打印我的荣誉"));

        systemPrivilegeList.add(new SystemPrivilege("辅导老师下载我的荣誉", SystemPrivilege.Type.Operation, "url", menu13,"下载我的荣誉"));

        SystemPrivilege menu14 = new SystemPrivilege("辅导老师寻求帮助", SystemPrivilege.Type.Meun, "url", null,"寻求帮助");
        systemPrivilegeList.add(menu14);


        //管理员
        SystemPrivilege menu15 = new SystemPrivilege("项目管理", SystemPrivilege.Type.Meun, "url", null,"项目管理") ;
        systemPrivilegeList.add(menu15);
        systemPrivilegeList.add(new SystemPrivilege("创建项目", SystemPrivilege.Type.Operation, "url", menu15,"创建项目") )  ;
        systemPrivilegeList.add(new SystemPrivilege("删除项目", SystemPrivilege.Type.Operation, "url", menu15,"删除项目") )  ;
        systemPrivilegeList.add(new SystemPrivilege("编辑项目", SystemPrivilege.Type.Operation, "url", menu15,"编辑项目") )  ;

        SystemPrivilege menu16 = new SystemPrivilege("公告管理", SystemPrivilege.Type.Meun, "url", null,"公告管理") ;
        systemPrivilegeList.add(menu16);
        systemPrivilegeList.add(new SystemPrivilege("发布公告", SystemPrivilege.Type.Operation, "url", menu16,"发布公告") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除公告", SystemPrivilege.Type.Operation, "url", menu16,"删除公告") ) ;
        systemPrivilegeList.add(new SystemPrivilege("编辑公告", SystemPrivilege.Type.Operation, "url", menu16,"编辑公告") ) ;

        SystemPrivilege menu17 = new SystemPrivilege("课程资源库管理", SystemPrivilege.Type.Meun, "url", null,"课程资源库管理") ;
        systemPrivilegeList.add(menu17);
        systemPrivilegeList.add(new SystemPrivilege("新增课程", SystemPrivilege.Type.Operation, "url", menu17,"新增课程") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除课程", SystemPrivilege.Type.Operation, "url", menu17,"删除课程") ) ;
        systemPrivilegeList.add(new SystemPrivilege("编辑课程", SystemPrivilege.Type.Operation, "url", menu17,"编辑课程") ) ;
        systemPrivilegeList.add(new SystemPrivilege("新增课程作业", SystemPrivilege.Type.Operation, "url", menu17,"新增作业") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除课程作业", SystemPrivilege.Type.Operation, "url", menu17,"删除作业") ) ;
        systemPrivilegeList.add(new SystemPrivilege("编辑课程作业", SystemPrivilege.Type.Operation, "url", menu17,"编辑作业") ) ;


        SystemPrivilege menu18 = new SystemPrivilege("行政区域管理", SystemPrivilege.Type.Meun, "url", null,"行政区域管理") ;
        systemPrivilegeList.add(menu18);
        systemPrivilegeList.add(new SystemPrivilege("添加区域", SystemPrivilege.Type.Operation, "url", menu18,"添加区域") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除区域", SystemPrivilege.Type.Operation, "url", menu18,"删除区域") ) ;
        systemPrivilegeList.add(new SystemPrivilege("编辑区域", SystemPrivilege.Type.Operation, "url", menu18,"编辑区域") )  ;
        systemPrivilegeList.add(new SystemPrivilege("导出区域", SystemPrivilege.Type.Operation, "url", menu18,"导出区域") )  ;
        systemPrivilegeList.add(new SystemPrivilege("分配区域管理员", SystemPrivilege.Type.Operation, "url", menu18,"分配区域管理员") )  ;

        SystemPrivilege menu19 = new SystemPrivilege("行政单位管理", SystemPrivilege.Type.Meun, "url", null,"行政单位管理") ;
        systemPrivilegeList.add(menu19);
        systemPrivilegeList.add(new SystemPrivilege("添加机构", SystemPrivilege.Type.Operation, "url", menu19,"添加机构") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除机构", SystemPrivilege.Type.Operation, "url", menu19,"删除机构") ) ;
        systemPrivilegeList.add(new SystemPrivilege("编辑机构", SystemPrivilege.Type.Operation, "url", menu19,"编辑机构") ) ;
        systemPrivilegeList.add(new SystemPrivilege("导出机构", SystemPrivilege.Type.Operation, "url", menu19,"导出机构") ) ;

        SystemPrivilege menu20 = new SystemPrivilege("角色管理", SystemPrivilege.Type.Meun, "url", null,"角色管理") ;
        systemPrivilegeList.add(menu20);
        systemPrivilegeList.add(new SystemPrivilege("添加角色", SystemPrivilege.Type.Operation, "url", menu20,"添加角色") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除角色", SystemPrivilege.Type.Operation, "url", menu20,"删除角色") ) ;
        systemPrivilegeList.add(new SystemPrivilege("编辑角色", SystemPrivilege.Type.Operation, "url", menu20,"编辑角色") ) ;

        SystemPrivilege menu21 = new SystemPrivilege("用户信息管理", SystemPrivilege.Type.Meun, "url", null,"用户信息管理") ;
        systemPrivilegeList.add(menu21);
        systemPrivilegeList.add(new SystemPrivilege("用户信息查询", SystemPrivilege.Type.Operation, "url", menu21,"查询") ) ;
        systemPrivilegeList.add(new SystemPrivilege("批量导入", SystemPrivilege.Type.Operation, "url", menu21,"批量导入") ) ;
        systemPrivilegeList.add(new SystemPrivilege("导出", SystemPrivilege.Type.Operation, "url", menu21,"导出") ) ;
        systemPrivilegeList.add(new SystemPrivilege("删除用户", SystemPrivilege.Type.Operation, "url", menu21,"删除用户") ) ;
        systemPrivilegeList.add(new SystemPrivilege("用户密码重置", SystemPrivilege.Type.Operation, "url", menu21,"用户密码重置") ) ;

        SystemPrivilege menu22 = new SystemPrivilege("学情在线督导", SystemPrivilege.Type.Meun, "url", null,"学情在线督导") ;
        systemPrivilegeList.add(menu22);
        systemPrivilegeList.add(new SystemPrivilege("学情查询", SystemPrivilege.Type.Operation, "url", menu22,"学情查询") ) ;
        systemPrivilegeList.add(new SystemPrivilege("学情导出", SystemPrivilege.Type.Operation, "url", menu22,"学情导出") ) ;

        SystemPrivilege menu23 = new SystemPrivilege("子管理员管理", SystemPrivilege.Type.Meun, "url", null,"子管理员管理") ;
        systemPrivilegeList.add(menu23);
        systemPrivilegeList.add(new SystemPrivilege("添加管理员", SystemPrivilege.Type.Operation, "url", menu23,"添加管理员") )   ;
        systemPrivilegeList.add(new SystemPrivilege("删除管理员", SystemPrivilege.Type.Operation, "url", menu23,"删除管理员") )   ;
        systemPrivilegeList.add(new SystemPrivilege("编辑管理员", SystemPrivilege.Type.Operation, "url", menu23,"编辑管理员") )   ;

        SystemPrivilege menu24 = new SystemPrivilege("管理员我的个人信息", SystemPrivilege.Type.Meun, "url", null,"我的个人信息") ;
        systemPrivilegeList.add(menu24);
        systemPrivilegeList.add(new SystemPrivilege("管理员我的个人信息保存", SystemPrivilege.Type.Operation, "url", menu24,"保存") )   ;
        privilegeService.batchSave(systemPrivilegeList);
    }

    private void initSystemRoles() {
        //To change body of created methods use File | Settings | File Templates.
             Role student = new Role("student")     ;

    }

    public void init() throws ServletException {
        super.init();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
