package com.zikool.edu.db;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

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

    public T queryForObject(String sql, RowMapper<T> rm, Object... obj) throws DataAccessException;

    public List<T> queryObjectList(String sql, RowMapper<T> rm, Object... obj) throws DataAccessException;

//    public <T extends Object> List<T> queryEntityList(String sql, Class<T> cls, Object... obj) throws DataAccessException;
//
//    public <T extends Object> List<T> queryList(String sql, RowMapper<T> rowMapper, Object... obj) throws DataAccessException;
}
