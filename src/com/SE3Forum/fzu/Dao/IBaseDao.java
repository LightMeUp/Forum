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
    public boolean addEntity(T object);
    // delete Row
    public void deleteEntity(T object);

    // update row
    public void updateEntity(T object);
    public T findEntity(Class<T>clazz, Serializable id);
    // query all entities
    public List<T> findEntities(String sql);
    public java.math.BigInteger getRows(String tableName);
}
