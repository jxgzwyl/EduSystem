package com.zikool.edu.test;


import com.zikool.edu.db.DaoBase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: longtc
 * Date: 13-5-27
 * Time: 上午10:13
 * To change this template use File | Settings | File Templates.
 */
public class DbTestServlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter w = resp.getWriter();
        DaoBase db = new DaoBase();
        
//        String insert1 = "insert into user values(null, 'longyao', 'longyao'),(null, 'longtc', 'longtc'),(null, 'longtongcan', 'longtongcan')";
//        String insert2 = "insert into user values(null, ?, ?)";
//        db.add(insert1);
//        db.add(insert2, "test", "test");
        
//        String sql = "select * from user";
//        List<User> list = db.queryList(sql, new RowMapper<User>() {
//            @Override
//            public User mapRow(ResultSet rs) throws SQLException {
//                User user = new User();
//                user.setId(rs.getInt("id"));
//                user.setName(rs.getString("name"));
//                user.setPassword(rs.getString("password"));
//                return user;
//            };
//        });
//        print(list, w);
        
        String sql = "select * from user where id > ? and id <= ?";
        List<User> list = db.queryList(sql, User.class, 1, 4);
        print(list, w);
    }
    
    private void print(List<User> list, PrintWriter w) {
        for (User u : list) {
            System.out.println("id = " + u.getId() + ",name = " + u.getName() + ",pwd = " + u.getPassword());
            w.print("id = " + u.getId() + ",name = " + u.getName() + ",pwd = " + u.getPassword());
            w.println();
        }
    }
}
