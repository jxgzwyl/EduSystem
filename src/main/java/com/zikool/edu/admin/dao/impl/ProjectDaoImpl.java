package com.zikool.edu.admin.dao.impl;

import com.zikool.edu.admin.bean.ProjectBean;
import com.zikool.edu.admin.dao.ProjectDao;
import com.zikool.edu.db.DaoBase;
import com.zikool.edu.db.JDBCDaoBase;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-6-2
 * Time: 下午4:37
 * To change this template use File | Settings | File Templates.
 */
public class ProjectDaoImpl implements ProjectDao {

    private DaoBase daoBase;

    public ProjectDaoImpl() {
        daoBase = new JDBCDaoBase();
    }

    @Override
    public int addProject(ProjectBean bean) {
        StringBuilder sb = new StringBuilder();
        sb.append("insert into ").append(ProjectBean.TB_NAME).append(" values(?, ?, ?, ?, ?, ?)");
        return daoBase.add(sb.toString(), bean.getProjectId(), bean.getManagerManName(), bean.getStartTime(),
                bean.getEndTime(), bean.getManagerManName(), bean.getProjectStatus());
    }

    @Override
    public int editProject(ProjectBean bean) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int deleteProject(ProjectBean bean) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<ProjectBean> getProjectList() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
