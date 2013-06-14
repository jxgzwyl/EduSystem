package com.zikool.edu.common.bean;

import com.zikool.edu.common.privilege.Role;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午5:42
 * To change this template use File | Settings | File Templates.
 */
/*CREATE TABLE `tb_user` (
        `user_id` int(11) NOT NULL auto_increment,
        `user_name` varchar(32) NOT NULL,
        `user_identity_card` char(24) NOT NULL,
        `user_login_name` varchar(32) default NULL,
        `role_name` varchar(8) default NULL,
        `user_gender` char(8) default NULL,
        `user_organization` varchar(64) default NULL,
        `user_grade` varchar(16) default NULL,
        `user_professional` varchar(16) default NULL,
        `teach_subject` varchar(16) default NULL,
        `phone` varchar(16) default NULL,
        `email` varchar(32) default NULL,
        `qq` varchar(16) default NULL,
        `blog` varchar(64) default NULL,
        `address` varchar(64) default NULL,
        `password` varchar(32) NOT NULL,
        `organization_id` int(11) default NULL,
        `administrator_id` int(11) default NULL,
        `role_id` int(11) default NULL,
        PRIMARY KEY  (`user_id`),
        KEY `role_id` (`role_id`),
        KEY `administrator_id` (`administrator_id`),
        KEY `organization_id` (`organization_id`),
        CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_role` (`role_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
        CONSTRAINT `tb_user_ibfk_2` FOREIGN KEY (`administrator_id`) REFERENCES `tb_user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE,
        CONSTRAINT `tb_user_ibfk_3` FOREIGN KEY (`organization_id`) REFERENCES `tb_organization` (`organization_id`) ON DELETE NO ACTION ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
public class User {
    private int id;
    private String name;
    private String identityCard;
    private String loginName;
    private String password;
    private String roleName;
    private char gender = '男';
    private String organizationName;
    private String grade;
    private String professional;
    private String teachSubject;
    private String phoneNum;
    private String email;
    private String qq;
    private String blog;
    private String address;
    private Organization organization;
    private User areaAdmin;
    private Role role;

    public User() {
    }

    public User(String name, String identityCard, String loginName, String password) {
        this(loginName, password);
        this.name = name;
        this.identityCard = identityCard;
    }

    public User(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public User(String name, String identityCard, Role role, User areaAdmin, Organization organization, String address, String professional, String grade, String password, char gender, String phoneNum, String teachSubject) {
        this.name = name;
        this.identityCard = identityCard;
        this.role = role;
        this.areaAdmin = areaAdmin;
        this.organization = organization;
        this.address = address;
        this.professional = professional;
        this.grade = grade;
        this.password = password;
        this.gender = gender;
        this.phoneNum = phoneNum;
        this.teachSubject = teachSubject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getTeachSubject() {
        return teachSubject;
    }

    public void setTeachSubject(String teachSubject) {
        this.teachSubject = teachSubject;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getAreaAdmin() {
        return areaAdmin;
    }

    public void setAreaAdmin(User areaAdmin) {
        this.areaAdmin = areaAdmin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
