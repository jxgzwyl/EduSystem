package com.zikool.edu.auth.bean;

import java.util.Set;

public class TbUser {
    private Integer userId;
    private String userName;
    private String userIdentityCard;
    private String userLoginName;
    private String roleName;
    private String userGender;
    private String userOrganization;
    private String userGrade;
    private String userProfessional;
    private String teachSubject;
    private String phone;
    private String email;
    private String qq;
    private String blog;
    private String address;
    private String password;
    private Integer organizationId;
    private Integer administratorId;
    private Integer roleId;
    
    private Set<String> urls;
    
    public Set<String> getUrls() {
		return urls;
	}

	public void setUrls(Set<String> urls) {
		this.urls = urls;
	}

	public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdentityCard() {
        return userIdentityCard;
    }

    public void setUserIdentityCard(String userIdentityCard) {
        this.userIdentityCard = userIdentityCard;
    }

    public String getUserLoginName() {
        return userLoginName;
    }

    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserOrganization() {
        return userOrganization;
    }

    public void setUserOrganization(String userOrganization) {
        this.userOrganization = userOrganization;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserProfessional() {
        return userProfessional;
    }

    public void setUserProfessional(String userProfessional) {
        this.userProfessional = userProfessional;
    }

    public String getTeachSubject() {
        return teachSubject;
    }

    public void setTeachSubject(String teachSubject) {
        this.teachSubject = teachSubject;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}