package com.zikool.edu.db;

import com.zikool.edu.utils.GenericsUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
@Repository
@Transactional
public class JDBCDaoBase<T> implements DaoBase<T> {
    protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
    @Resource
    protected JdbcTemplate jdbcTemplate;

    @Override
    public int add(String sql, Object... obj) throws DataAccessException {
        System.out.println("jdbcTemplate-------------->"+jdbcTemplate);
        return jdbcTemplate.update(sql, obj);
    }

    @Override
    public int delete(String sql, Object... obj)throws DataAccessException {
        return jdbcTemplate.update(sql, obj);
    }

    @Override
    public int update(String sql, Object... obj)throws DataAccessException {
        return jdbcTemplate.update(sql, obj);
    }
     public T  queryForObject(String sql,Object ...obj){
         return jdbcTemplate.queryForObject(sql,entityClass,obj);
     }
    public List<T> query(String sql, BeanPropertyRowMapper<T> rowMapper, Object... obj) throws DataAccessException{
        return jdbcTemplate.query(sql, obj, rowMapper);
    }

    @Override
    public List<Map<String, Object>> queryObjectList(String sql, Object... obj)throws DataAccessException {

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

    @Override
    public <T extends Object> List<T> queryEntityList(String sql, Class<T> cls, Object... obj) throws DataAccessException{

        Connection con = DataSourceManager.getInstance().getConnection();
        PreparedStatement statement = null;
        ResultSet set = null;

        List<T> results = new ArrayList<T>();

        try {
            statement = con.prepareStatement(sql);
            setPreparedArgs(statement, obj);
            set = statement.executeQuery();
            String[] names = columnNames(set.getMetaData());

            Object entity = null;
            Field[] fields = cls.getDeclaredFields();
            while (set.next()) {
                entity = cls.newInstance();
                setFields(entity, fields, names, set);
                results.add((T) entity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DataSourceManager.getInstance().release(con, statement, set);
        }
        return results;
    }

    @Override
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

    private void setFields(Object obj, Field[] fields, String[] columnNames, ResultSet rs) throws SQLException, IllegalAccessException {
        for (int i = 0; i < columnNames.length; i++) {
            for (int j = 0; j < fields.length; j++) {
                if (fields[j].getName().equalsIgnoreCase(columnNames[i])) {
                    fields[j].setAccessible(true);
                    fields[j].set(obj, rs.getObject(columnNames[i]));
                    break;
                }
            }
        }
    }

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
