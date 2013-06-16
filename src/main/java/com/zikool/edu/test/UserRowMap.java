package com.zikool.edu.test;

import com.zikool.edu.common.bean.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-16
 * Time: 下午7:41
 * To change this template use File | Settings | File Templates.
 */

public class UserRowMap implements RowMapper<User>{
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setName(rs.getString("user_name"));
        user.setIdentityCard(rs.getString("user_identity_card"));
        user.setLoginName(rs.getString("user_login_name"));
        user.setGender(rs.getString("user_gender"));
        user.setOrganizationName(rs.getString("user_organization"));
        user.setGrade(rs.getString("user_grade"));
        user.setProfessional(rs.getString("user_professional"));
        user.setTeachSubject(rs.getString("teach_subject"));
        user.setPhoneNum(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setQq(rs.getString("qq"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        return user;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
