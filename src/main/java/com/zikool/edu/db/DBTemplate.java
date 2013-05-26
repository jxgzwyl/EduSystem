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
public class DBTemplate {

//    public DBTemplate() {
//        super();
//    }
//
//    public int add(String sql, Object...obj) {
//        return curd(sql, obj);
//    }
//
//    public int delete(String sql, Object...obj) {
//        return curd(sql, obj);
//    }
//
//    public int update(String sql, Object...obj) {
//        return curd(sql, obj);
//    }
//
//    public List<Map<String, Object>> queryObjectList(String sql, Object...obj) {
//
//        Connection con = getConnection();
//        PreparedStatement statement = null;
//        ResultSet set = null;
//
//        List<Map<String, Object>> results = new ArrayList<Map<String, Object>>();
//        Map<String, Object> map = null;
//
//        try {
//            statement = con.prepareStatement(sql);
//            setPreparedArgs(statement, obj);
//            set = statement.executeQuery();
//            String[] names = columnNames(set.getMetaData());
//
//            while(set.next()) {
//                map = new HashMap<String, Object>();
//                for (int i = 0; i < names.length; i++) {
//                    map.put(names[i], set.getObject(i+1));
//                }
//                results.add(map);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeResult(set);
//            closeStatement(statement);
//            closeConnection(con);
//        }
//
//        return results;
//    }
//
//    public <T extends Object> List<T> queryList(String sql, Class<T> cls, Object...obj) {
//
//        Connection con = getConnection();
//        PreparedStatement statement = null;
//        ResultSet set = null;
//
//        List<T> results = new ArrayList<T>();
//
//        try {
//            statement = con.prepareStatement(sql);
//            setPreparedArgs(statement, obj);
//            set = statement.executeQuery();
//            String[] names = columnNames(set.getMetaData());
//
//            Object entity = null;
//            Field[] fields = cls.getDeclaredFields();
//            while(set.next()) {
//                entity = cls.newInstance();
//                setFields(entity, fields, names, set);
//                results.add((T)entity);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            closeResult(set);
//            closeStatement(statement);
//            closeConnection(con);
//        }
//        return results;
//    }
//
//    public  <T extends Object> List<T> queryList(String sql, RowMapper<T> rowMapper, Object...obj) {
//
//        Connection con = getConnection();
//        PreparedStatement statement = null;
//        ResultSet set = null;
//
//        List<T> results = new ArrayList<T>();
//
//        try {
//            statement = con.prepareStatement(sql);
//            setPreparedArgs(statement, obj);
//            set = statement.executeQuery();
//            while (set.next()) {
//                if (rowMapper != null) {
//                    results.add(rowMapper.mapRow(set));
//                }
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeResult(set);
//            closeStatement(statement);
//            closeConnection(con);
//        }
//
//        return results;
//    }
//
//    private void setFields(Object obj, Field[] fields, String[] columnNames, ResultSet rs) throws SQLException, IllegalAccessException{
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
//
//    private int curd(String sql, Object...obj) {
//
//        int count = -1;
//        Connection con = getConnection();
//        PreparedStatement pst = null;
//        try {
//            pst = con.prepareStatement(sql);
//            setPreparedArgs(pst, obj);
//            count = pst.executeUpdate();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            closeStatement(pst);
//            closeConnection(con);
//        }
//
//        return count;
//    }
//
//    private void setPreparedArgs(PreparedStatement pst, Object[] params) throws SQLException {
//        if (params != null && params.length > 0) {
//            for (int index = 0; index < params.length; index++) {
//                pst.setObject(index + 1, params[index]);
//            }
//        }
//    }
//
//    private String[] columnNames(ResultSetMetaData metaData) throws SQLException {
//        int count = metaData.getColumnCount();
//        String[] names = new String[count];
//        for (int i = 0; i < count; i++) {
//            names[i] = metaData.getColumnName(i + 1);
//        }
//        return names;
//    }
}
