package com.cn.httpsms.service;

import com.cn.httpsms.util.PageData;

import java.io.Serializable;
import java.util.List;


/**
 * @author liu.songgao
 * <p>创建时间: 2015年5月7日 下午1:39:15</p>
 * <p>描述：Service基础操作接口</p>
 * @version 1.0
 * @param <T>
 */
public interface BaseService<T extends Serializable> {
	
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
	
	public List<?> getResultListByNativeSql(String sql);
	
	public List<?> getResultListByNativeSql(String sql, Integer pageSize, Integer pageNumber);
	
	public List<?> getResultListByNativeSql(String sql, List<Object> param);
	
	public List<?> getResultListByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber);
	
	public long getCountByNativeSql(String sql);
	
	public long getCountByNativeSql(String sql, List<Object> param);
	
	public PageData pageQueryByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber);
	
	public PageData pageQueryByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count, Integer pageSize, Integer pageNumber);
	
	public List<?> getResultListMapByNativeSql(String sql);
	
	public List<?> getResultListMapByNativeSql(String sql, Integer pageSize, Integer pageNumber);
	
	public List<?> getResultListMapByNativeSql(String sql, List<Object> param);
	
	public List<?> getResultListMapByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber);
	
	public PageData pageQueryMapByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber);
	
	public PageData pageQueryMapByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count, Integer pageSize, Integer pageNumber);
	
	public void detach(T entity);
	
	public boolean contains(T entity);
	
	public Class<T> getEntityClass();
	
}
