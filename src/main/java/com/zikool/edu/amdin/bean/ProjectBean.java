package com.zikool.edu.amdin.bean;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-6-2
 * Time: 下午4:32
 * To change this template use File | Settings | File Templates.
 */
public class ProjectBean {

    public static final String TB_NAME = "tb_project";

    private int projectId;
    private String projectName;
    private Date startTime;
    private Date endTime;
    private String managerManName;
    private byte projectStatus;

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getManagerManName() {
        return managerManName;
    }

    public void setManagerManName(String managerManName) {
        this.managerManName = managerManName;
    }

    public byte getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(byte projectStatus) {
        this.projectStatus = projectStatus;
    }
}
