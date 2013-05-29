package com.zikool.edu.db;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-1-26
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */
public class DaoBase {

    public DaoBase() {
        super();
    }

    public int add(String sql, Object... obj) {
        return curd(sql, obj);
    }

    public int delete(String sql, Object... obj) {
        return curd(sql, obj);
    }

    public int update(String sql, Object... obj) {
        return curd(sql, obj);
    }

    public List<Map<String, Object>> queryObjectList(String sql, Object... obj) {

        Connection conn = DataSourceManager.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = null;

        try {
            statement = conn.prepareStatement(sql);
            setPreparedArgs(statement, obj);
            rs = statement.executeQuery();
            String[] names = columnNames(rs.getMetaData());

            while (rs.next()) {
                map = new HashMap<String, Object>();
                for (int i = 0; i < names.length; i++) {
                    map.put(names[i], rs.getObject(i + 1));
                }
                results.add(map);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DataSourceManager.getInstance().release(conn, statement, rs);
        }

        return results;
    }

    public <T extends Object> List<T> queryList(String sql, ResultSetHandler rsh, Object... obj) {

        Connection conn = DataSourceManager.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;


        try {
            statement = conn.prepareStatement(sql);
            setPreparedArgs(statement, obj);
            rs = statement.executeQuery();
            return (List<T>) rsh.handler(rs);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataSourceManager.getInstance().release(conn, statement, rs);
        }
        return null;
    }

    public <T extends Object> List<T> queryList(String sql, RowMapper<T> rowMapper, Object... obj) {

        Connection conn = DataSourceManager.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet rs = null;

        List<T> results = new ArrayList<T>();

        try {
            statement = conn.prepareStatement(sql);
            setPreparedArgs(statement, obj);
            rs = statement.executeQuery();
            while (rs.next()) {
                if (rowMapper != null) {
                    results.add(rowMapper.mapRow(rs));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DataSourceManager.getInstance().release(conn, statement, rs);
        }

        return results;
    }

//    private void setFields(Object obj, Field[] fields, String[] columnNames, ResultSet rs) throws SQLException, IllegalAccessException {
//        for (int i = 0; i < columnNames.length; i++) {
//            for (int j = 0; j < fields.length; j++) {
//                if (fields[j].getName().equalsIgnoreCase(columnNames[i])) {
//                    fields[j].setAccessible(true);
//                    fields[j].set(obj, rs.getObject(columnNames[i]));
//                    break;
//                }
//            }
//        }
//    }

    private int curd(String sql, Object... obj) {

        int count = -1;
        Connection conn = DataSourceManager.getInstance().getConnection();
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            setPreparedArgs(pst, obj);
            count = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DataSourceManager.getInstance().release(conn, pst, null);
        }

        return count;
    }

    private void setPreparedArgs(PreparedStatement pst, Object[] params) throws SQLException {
        if (params != null && params.length > 0) {
            for (int index = 0; index < params.length; index++) {
                pst.setObject(index + 1, params[index]);
            }
        }
    }

    private String[] columnNames(ResultSetMetaData metaData) throws SQLException {
        int count = metaData.getColumnCount();
        String[] names = new String[count];
        for (int i = 0; i < count; i++) {
            names[i] = metaData.getColumnName(i + 1);
        }
        return names;
    }
}

//代表的resultSet处理器
interface ResultSetHandler {
    public Object handler(ResultSet rs) throws SQLException;
}

//这个处理器用于把rs的数据封装到bean
class BeanHandler implements ResultSetHandler {
    private Class clazz;  //记住结果集的数据封装到哪一个对象中

    public BeanHandler(Class clazz) {
        this.clazz = clazz;
    }

    public Object handler(ResultSet rs) throws SQLException {
        Object obj = null;
        try {
            obj = clazz.newInstance();

            ResultSetMetaData meta = rs.getMetaData();
            int columnNum = meta.getColumnCount();
            if (rs.next()) {

                for (int i = 1; i <= columnNum; i++) {
                    Object value = rs.getObject(i); //取出某一列的数据
                    String columnName = meta.getColumnName(i); //当前列的列名

                    Field f = clazz.getDeclaredField(columnName);  //根据列名，从对象查找相应的属性
                    f.setAccessible(true);  //暴力反射以访问私有属性
                    f.set(obj, value);  //把值赋到对象的属性上
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    class BeanListHandler implements ResultSetHandler {
        private Class clazz;  //记住结果集的数据封装到哪一个对象中

        public BeanListHandler(Class clazz) {
            this.clazz = clazz;
        }

        public Object handler(ResultSet rs) throws SQLException {
            Object obj = null;
            List<Object> mResultList = new ArrayList<Object>();
            try {
                obj = clazz.newInstance();

                ResultSetMetaData meta = rs.getMetaData();
                int columnNum = meta.getColumnCount();
                while (rs.next()) {

                    for (int i = 1; i <= columnNum; i++) {
                        Object value = rs.getObject(i); //取出某一列的数据
                        String columnName = meta.getColumnName(i); //当前列的列名
                        //id  id
                        //name name
                        //money money

                        Field f = clazz.getDeclaredField(columnName);  //根据列名，从对象查找相应的属性
                        f.setAccessible(true);  //暴力反射以访问私有属性
                        f.set(obj, value);  //把值赋到对象的属性上
                    }
                    mResultList.add(obj);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return mResultList;
        }
    }
}