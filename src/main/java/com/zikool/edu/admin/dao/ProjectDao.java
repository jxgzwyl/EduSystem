package com.zikool.edu.admin.dao;

import com.zikool.edu.admin.bean.ProjectBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-6-2
 * Time: 下午4:33
 * To change this template use File | Settings | File Templates.
 */
public interface ProjectDao {

    public int addProject(ProjectBean bean);
    public int editProject(ProjectBean bean);
    public int deleteProject(ProjectBean bean);
    public List<ProjectBean> getProjectList();
}
