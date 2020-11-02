package com.cn.httpsms.service.impl;

import java.io.Serializable;
import java.util.List;

import com.cn.httpsms.dao.JpaBaseDao;
import com.cn.httpsms.dao.JpaNativeBaseDao;
import com.cn.httpsms.service.BaseService;
import com.cn.httpsms.util.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author liu.songgao
 * <p>创建时间: 2015年5月7日 下午1:39:58</p>
 * <p>描述：Service基础操作实现类</p>
 * @version 1.0
 * @param <T>
 */
@Service
@Transactional
public abstract class BaseServiceImpl<T extends Serializable> implements BaseService<T> {
	
	@Autowired
	protected JpaBaseDao<T> jpaBaseDao;
	
	@Autowired
	protected JpaNativeBaseDao jpaNativeBaseDao;

    @Override
	public void insert(T entity){
		jpaBaseDao.insert(entity);
	}
	
	@Override
	public void update(T entity){
		jpaBaseDao.update(entity);
	}
	
	@Override
	public void delete(T entity){
		jpaBaseDao.delete(entity);
	}
	
	@Override
	public void deleteById(Object id){
		jpaBaseDao.deleteById(id);
	}
	
	@Override
	public T find(Object key){
		return jpaBaseDao.find(key);
	}
	
	@Override
	public T find(Class<T> clazz, Object key){
		return jpaBaseDao.find(clazz, key);
	}
	
	@Override
	public void batchInsert(List<T> list){
		jpaBaseDao.batchInsert(list);
	}
	
	@Override
	public void batchUpdate(List<T> list){
		jpaBaseDao.batchUpdate(list);
	}
	
	@Override
	public void batchDelete(List<T> list){
		jpaBaseDao.batchDelete(list);
	}
	
	@Override
	public void batchDeleteByIds(Object[] ids){
		jpaBaseDao.batchDeleteByIds(ids);
	}
	
	@Override
	public List<T> getResultList(String hql){
		return jpaBaseDao.getResultList(hql);
	}
	
	@Override
	public List<T> getResultList(String hql, Integer pageSize, Integer pageNumber){
		return jpaBaseDao.getResultList(hql, pageSize, pageNumber);
	}
	
	@Override
	public List<T> getResultList(String hql, List<Object> param){
		return jpaBaseDao.getResultList(hql, param);
	}
	
	@Override
	public List<T> getResultList(String hql, List<Object> param, Integer pageSize, Integer pageNumber){
		return jpaBaseDao.getResultList(hql, param, pageSize, pageNumber);
	}
	
	@Override
	public long getCountByHql(String hql){
		return jpaBaseDao.getCountByHql(hql);
	}
	
	@Override
	public long getCountByHql(String hql, List<Object> param){
		return jpaBaseDao.getCountByHql(hql, param);
	}
	
	@Override
	public PageData pageQuery(String hql, String hql_count, Integer pageSize, Integer pageNumber){
		return jpaBaseDao.pageQuery(hql, hql_count, pageSize, pageNumber);
	}
	
	@Override
	public PageData pageQuery(String hql, List<Object> param, String hql_count, List<Object> param_count, Integer pageSize, Integer pageNumber){
		return jpaBaseDao.pageQuery(hql, param, hql_count, param_count, pageSize, pageNumber);
	}
	
	@Override
	public List<?> getResultListByNativeSql(String sql) {
		return jpaNativeBaseDao.getResultListByNativeSql(sql);
	}

	@Override
	public List<?> getResultListByNativeSql(String sql, Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.getResultListByNativeSql(sql, pageSize, pageNumber);
	}

	@Override
	public List<?> getResultListByNativeSql(String sql, List<Object> param) {
		return jpaNativeBaseDao.getResultListByNativeSql(sql, param);
	}

	@Override
	public List<?> getResultListByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.getResultListByNativeSql(sql, param, pageSize, pageNumber);
	}

	@Override
	public long getCountByNativeSql(String sql) {
		return jpaNativeBaseDao.getCountByNativeSql(sql);
	}

	@Override
	public long getCountByNativeSql(String sql, List<Object> param) {
		return jpaNativeBaseDao.getCountByNativeSql(sql, param);
	}

	@Override
	public PageData pageQueryByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.pageQueryByNativeSql(sql, sql_count, pageSize, pageNumber);
	}

	@Override
	public PageData pageQueryByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count,
			Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.pageQueryByNativeSql(sql, param, sql_count, param_count, pageSize, pageNumber);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql) {
		return jpaNativeBaseDao.getResultListMapByNativeSql(sql);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql, Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.getResultListMapByNativeSql(sql, pageSize, pageNumber);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql, List<Object> param) {
		return jpaNativeBaseDao.getResultListByNativeSql(sql, param);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.getResultListByNativeSql(sql, pageSize, pageNumber);
	}

	@Override
	public PageData pageQueryMapByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.pageQueryMapByNativeSql(sql, sql_count, pageSize, pageNumber);
	}

	@Override
	public PageData pageQueryMapByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count,
			Integer pageSize, Integer pageNumber) {
		return jpaNativeBaseDao.pageQueryMapByNativeSql(sql, param, sql_count, param_count, pageSize, pageNumber);
	}
	
	@Override
	public void detach(T entity){
		jpaBaseDao.detach(entity);
	}
	
	@Override
	public boolean contains(T entity){
		return jpaBaseDao.contains(entity);
	}
	
	@Override
	public Class<T> getEntityClass(){
		return jpaBaseDao.getEntityClass();
	}
	
}
