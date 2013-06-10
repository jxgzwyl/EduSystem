package com.zikool.edu.common.bean;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-10
 * Time: 下午6:22
 * To change this template use File | Settings | File Templates.
 */
/*CREATE TABLE `tb_organization` (
        `organization_id` int(11) NOT NULL auto_increment,
        `organization_name` varchar(16) default NULL,
        `city_area_code` varchar(16) default NULL,
        `county_area_code` varchar(16) default NULL,
        `contact_info` varchar(64) default NULL,
        `address` varchar(128) default NULL,
        `regional_administrator_id` int(11) default NULL COMMENT 'Regional Administrator ID',
        PRIMARY KEY  (`organization_id`),
        KEY `regional_administrator_id` (`regional_administrator_id`),
        CONSTRAINT `tb_organization_ibfk_1` FOREIGN KEY (`regional_administrator_id`) REFERENCES `tb_user` (`user_id`) ON DELETE NO ACTION ON UPDATE CASCADE
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;*/
public class Organization {
      private int ID;
      private String name;
      //单位机构的市级编码
      private String cityCode;
     //单位机构的区县编码
      private String countyCode;
      private String contactInfo;
      private String address;
      private User areaAdmin;

    public Organization(String name, String cityCode, String countyCode, String contactInfo, String address) {
        this.name = name;
        this.cityCode = cityCode;
        this.countyCode = countyCode;
        this.contactInfo = contactInfo;
        this.address = address;
    }

    public Organization(String name, String cityCode, String countyCode, String contactInfo, String address, User areaAdmin) {
        this(name,cityCode,countyCode,contactInfo,address);
        this.areaAdmin = areaAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getAreaAdmin() {
        return areaAdmin;
    }

    public void setAreaAdmin(User areaAdmin) {
        this.areaAdmin = areaAdmin;
    }
}
