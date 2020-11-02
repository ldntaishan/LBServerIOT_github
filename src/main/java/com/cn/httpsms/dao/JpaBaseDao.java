package com.cn.httpsms.dao;

import com.cn.httpsms.util.PageData;

import java.io.Serializable;
import java.util.List;

/**
 * @author liu.songgao
 * <p>创建时间: 2015年5月7日 下午1:36:42</p>
 * <p>描述：jpa基础操作接口</p>
 * @version 1.0
 * @param <T>
 */
public interface JpaBaseDao<T extends Serializable> {
	public Class<T> getEntityClass();
	
	public void insert(T entity);
	
	public void update(T entity);
	
	public void delete(T entity);
	
	public void deleteById(Object id);
	
	public T find(Object key);
	
	public T find(Class<T> clazz, Object key);
		
	public void batchInsert(List<T> list);
	
	public void batchUpdate(List<T> list);
	
	public void batchDelete(List<T> list);
	
	public void batchDeleteByIds(Object[] ids);
	
	public List<T> getResultList(String hql);
	
	public List<T> getResultList(String hql, Integer pageSize, Integer pageNumber);
	
	public List<T> getResultList(String hql, List<Object> param);
	
	public List<T> getResultList(String hql, List<Object> param, Integer pageSize, Integer pageNumber);
	
	public long getCountByHql(String hql);
	
	public long getCountByHql(String hql, List<Object> param);
	
	public PageData pageQuery(String hql, String hql_count, Integer pageSize, Integer pageNumber);
	
	public PageData pageQuery(String hql, List<Object> param, String hql_count, List<Object> param_count, Integer pageSize, Integer pageNumber);
	
	public void flush();
	
	public void detach(T entity);
	
	public boolean contains(T entity);
	
}
