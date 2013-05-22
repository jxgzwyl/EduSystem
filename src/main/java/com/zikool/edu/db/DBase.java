package com.zikool.edu.db;
//test
import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-1-26
 * Time: 下午8:27
 * To change this template use File | Settings | File Templates.
 */
public class DBase {

    public void init() {
        try {
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("proxool.cooking");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeResult(ResultSet set) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
