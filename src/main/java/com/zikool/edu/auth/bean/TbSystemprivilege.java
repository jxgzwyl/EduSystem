package com.zikool.edu.auth.bean;

public class TbSystemprivilege {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_systemprivilege.privilege_id
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    private Integer privilegeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_systemprivilege.privilege_type
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    private Byte privilegeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_systemprivilege.privilege_name
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    private String privilegeName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_systemprivilege.privilege_id
     *
     * @return the value of tb_systemprivilege.privilege_id
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_systemprivilege.privilege_id
     *
     * @param privilegeId the value for tb_systemprivilege.privilege_id
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_systemprivilege.privilege_type
     *
     * @return the value of tb_systemprivilege.privilege_type
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    public Byte getPrivilegeType() {
        return privilegeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_systemprivilege.privilege_type
     *
     * @param privilegeType the value for tb_systemprivilege.privilege_type
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    public void setPrivilegeType(Byte privilegeType) {
        this.privilegeType = privilegeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_systemprivilege.privilege_name
     *
     * @return the value of tb_systemprivilege.privilege_name
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    public String getPrivilegeName() {
        return privilegeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column tb_systemprivilege.privilege_name
     *
     * @param privilegeName the value for tb_systemprivilege.privilege_name
     *
     * @mbggenerated Sat Jun 15 15:44:47 CST 2013
     */
    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }
}