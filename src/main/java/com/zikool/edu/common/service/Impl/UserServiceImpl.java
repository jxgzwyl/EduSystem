package com.zikool.edu.common.service.Impl;

import com.zikool.edu.common.bean.User;
import com.zikool.edu.common.service.UserService;
import com.zikool.edu.config.Config;
import com.zikool.edu.db.JDBCDaoBase;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;


/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-6-13
 * Time: 上午11:59
 * To change this template use File | Settings | File Templates.
 */
@Service("userService")
public class UserServiceImpl extends JDBCDaoBase<User> implements UserService {

    @Override
    public User getUserByLoginNameAndPassword(String loginName, String password) {
        if (StringUtils.isEmpty(password) == true) {
            password = "";
        }

        String passwordMD5Digest = DigestUtils.md5DigestAsHex(password.getBytes());
        StringBuilder sb = new StringBuilder();
        //SELECT * FROM `tb_user` WHERE user_login_name="jxgzwyl" and `password`="1234";
        sb.append("SELECT * FROM")
                .append(Config.TB_NAME_USER)
                .append("WHERE user_longin_name=?")
                .append("AND password=?");

        return jdbcTemplate.queryForObject(sb.toString(), User.class, loginName, password);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User getUserById(int Id) {
        //SELECT * FROM `tb_user` WHERE user_id =1;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM")
                .append(Config.TB_NAME_USER)
                .append("WHERE user_id=?");
        return super.queryForObject(sb.toString(), Id);
    }

    @Override
    public User getUserByIdentityCard(String identityCard) {
        //     SELECT * FROM `tb_user` WHERE user_identity_card =36042419********;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM")
                .append(Config.TB_NAME_USER)
                .append("WHERE user_identity_card=?");
        return super.queryForObject(sb.toString(), identityCard);
    }

    @Override
    public User getUserByIdentityCardAndPassword(String identityCard, String password) {
        //SELECT * FROM `tb_user` WHERE user_identity_card =360424198610**** AND `password`=1234;
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM")
                .append(Config.TB_NAME_USER)
                .append("WHERE user_identity_card=?")
                .append("AND password=?");
        return super.queryForObject(sb.toString(), identityCard, password);
    }

    @Override
    public int save(User user) throws IllegalAccessException {
        String password = user.getPassword();
        if (user == null || StringUtils.isEmpty(password)) {
            throw new IllegalAccessException();
        }
        String passwordMD5Digest = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(passwordMD5Digest);
//        INSERT INTO tb_user (user_name,user_identity_card,user_login_name,role_name,user_gender,
//                user_organization,user_grade,user_professional,teach_subject,phone,email,qq,
//                blog,address,password,organization_id,administrator_id,role_id) values ("李四","360424198610041234",
//                "jxtest","男","江西修水二中");
        StringBuilder sb = new StringBuilder();

        sb.append("INSERT INTO")
                .append(Config.TB_NAME_USER)
                .append("(user_name,user_identity_card,user_login_name,role_name,user_gender,")
                .append("user_organization, user_grade, user_professional, teach_subject, phone, email,qq")
                .append(",blog, address, password, organization_id, administrator_id,role_id)")
                .append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        return super.add(sb.toString(), user.getName(), user.getIdentityCard(), user.getLoginName(), user.getRole().getName(), user.getGender()
                , user.getOrganization(), user.getGrade(), user.getProfessional(), user.getTeachSubject(), user.getPhoneNum(),
                user.getEmail(), user.getQq(), user.getBlog(), user.getAddress(), user.getPassword(), user.getOrganization().getID(), user.getAreaAdmin().getId(),
                user.getRole().getID());
    }

    @Override
    public int update(User user) throws IllegalAccessException {
        //UPDATE tb_user set user_name="王五" WHERE user_id=11;
        if (user == null) {
            throw new IllegalAccessException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE")
                .append(Config.TB_NAME_USER)
                .append("set user_name=?,user_identity_card=?,user_login_name=?,role_name=?,user_gender=?,")
                .append("user_organization=?, user_grade=?, user_professional=?, teach_subject=?, phone=?, email=?,qq=?")
                .append(",blog=?, address=?, password=?, organization_id=?, administrator_id=?,role_id=?)")
                .append("WHERE user_id=?");
        return super.add(sb.toString(), user.getName(), user.getIdentityCard(), user.getLoginName(), user.getRole().getName(), user.getGender()
                , user.getOrganization(), user.getGrade(), user.getProfessional(), user.getTeachSubject(), user.getPhoneNum(),
                user.getEmail(), user.getQq(), user.getBlog(), user.getAddress(), user.getPassword(), user.getOrganization().getID(), user.getAreaAdmin().getId(),
                user.getRole().getID(), user.getId());
    }

    @Override
    public int delete(int Id) {
        //DELETE FROM tb_user WHERE user_id=11;
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM")
                .append(Config.TB_NAME_USER)
                .append("WHERE user_id=?");
        return super.delete(sb.toString(), Id);  //To change body of implemented methods use File | Settings | File Templates.
    }
}
