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
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con = null;
        }
    }

    public void closeStatement(Statement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement = null;
        }
    }

    public void closeResult(ResultSet set) {
        if (set != null) {
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            set = null;
        }
    }

    public void release(Connection conn, Statement st, ResultSet rs) {
        closeStatement(st);
        closeResult(rs);
        closeConnection(conn);
    }
}
