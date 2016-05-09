package com.SE3Forum.fzu.Dao;

import org.hibernate.Query;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Feng on 5/4/16.
 */
public interface IBaseDao<T> {

    // 添加数据
    public boolean add(T object);
    // delete Row
    public void delete(T object);

    // update row
    public void update(T object);
    public T find(Class<T>clazz, Serializable id);
    // query all entities
    public List<T> listAll(String sql);
    public java.math.BigInteger getRows(String tableName);
}
