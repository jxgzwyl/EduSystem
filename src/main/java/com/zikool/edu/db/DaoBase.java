package com.zikool.edu.db;

import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: longyao
 * Date: 13-6-2
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
public interface DaoBase<T> {

    public int add(String sql, Object... obj) throws DataAccessException;

    public int delete(String sql, Object... obj) throws DataAccessException;

    public int update(String sql, Object... obj) throws DataAccessException;

    public List<Map<String, Object>> queryObjectList(String sql, Object... obj) throws DataAccessException;

    public <T extends Object> List<T> queryEntityList(String sql, Class<T> cls, Object... obj) throws DataAccessException;

    public <T extends Object> List<T> queryList(String sql, RowMapper<T> rowMapper, Object... obj) throws DataAccessException;
}
