package com.zikool.edu.db;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-5-26
 * Time: 下午6:14
 * To change this template use File | Settings | File Templates.
 */
public class DataSourceManager {
    private static DataSourceManager mDataSourceManager;
    private static Object mLockObject = new Object();

    private DataSourceManager() {
    }

    public static DataSourceManager getInstance() {
        if (mDataSourceManager == null) {
            synchronized (mLockObject) {
                if (mDataSourceManager == null) {
                    mDataSourceManager = new DataSourceManager();
                }
            }
        }
        return mDataSourceManager;
    }

    static {
        try {
            Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("proxool.edu");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
                con = null;
            } catch (SQLException e) {
                con = null;
                e.printStackTrace();
            }
        }
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
                statement = null;
            } catch (SQLException e) {
                statement = null;
                e.printStackTrace();
            }
        }
    }

    public void closeResult(ResultSet set) {
        if (set != null) {
            try {
                set.close();
                set = null;
            } catch (SQLException e) {
                set = null;
                e.printStackTrace();
            }
        }
    }

    public void release(Connection conn, Statement st, ResultSet rs) {
        closeConnection(conn);
        closeStatement(st);
        closeResult(rs);
    }
}
