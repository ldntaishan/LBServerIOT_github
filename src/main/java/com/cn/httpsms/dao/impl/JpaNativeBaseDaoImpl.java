package com.cn.httpsms.dao.impl;

import com.cn.httpsms.dao.JpaNativeBaseDao;
import com.cn.httpsms.util.PageData;
import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

/**
 * @author liu.songgao
 * <p>创建时间: 2015年5月7日 下午1:38:39</p>
 * <p>描述：jpa基础操作实现类，基于原生sql</p>
 * @version 1.0
 */
@SuppressWarnings("serial")
@Repository("jpaNaviteBaseDao")
public class JpaNativeBaseDaoImpl implements JpaNativeBaseDao {

	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<?> getResultListByNativeSql(String sql) {
		return getResultListByNativeSql(sql, false);
	}

	@Override
	public List<?> getResultListByNativeSql(String sql, Integer pageSize, Integer pageNumber) {
		return getResultListByNativeSql(sql, pageSize, pageNumber, false);
	}

	@Override
	public List<?> getResultListByNativeSql(String sql, List<Object> param) {
		return getResultListByNativeSql(sql, param, false);
	}

	@Override
	public List<?> getResultListByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber) {
		return getResultListByNativeSql(sql, param, pageSize, pageNumber, false);
	}

	@Override
	public long getCountByNativeSql(String sql) {
		return (Long)em.createNativeQuery(sql).getSingleResult();
	}

	@Override
	public long getCountByNativeSql(String sql, List<Object> param) {
		Query query = em.createNativeQuery(sql);
		if (param != null && param.size() > 0) {
			for (int i = 0, n = param.size(); i < n; i++) {
				query.setParameter(i + 1, param.get(i));
			}
		}
		return ((BigInteger)query.getSingleResult()).longValue();
	}

	@Override
	public PageData pageQueryByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber) {
		return pageQueryByNativeSql(sql, sql_count, pageSize, pageNumber, false);
	}

	@Override
	public PageData pageQueryByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count,
			Integer pageSize, Integer pageNumber) {
		return pageQueryByNativeSql(sql, param, sql_count, param_count, pageSize, pageNumber, false);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql) {
		return getResultListByNativeSql(sql, true);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql, Integer pageSize, Integer pageNumber) {
		return getResultListByNativeSql(sql, pageSize, pageNumber, true);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql, List<Object> param) {
		return getResultListByNativeSql(sql, param, true);
	}

	@Override
	public List<?> getResultListMapByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber) {
		return getResultListByNativeSql(sql, param, pageSize, pageNumber, true);
	}

	@Override
	public PageData pageQueryMapByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber) {
		return pageQueryByNativeSql(sql, sql_count, pageSize, pageNumber, true);
	}

	@Override
	public PageData pageQueryMapByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count,
			Integer pageSize, Integer pageNumber) {
		return pageQueryByNativeSql(sql, param, sql_count, param_count, pageSize, pageNumber, true);
	}
	
	
	private List<?> getResultListByNativeSql(String sql, boolean isMapResult) {
		Query query = em.createNativeQuery(sql);
		if(isMapResult) 
			query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}

	private List<?> getResultListByNativeSql(String sql, Integer pageSize, Integer pageNumber, boolean isMapResult) {
		if (pageSize == null || pageSize <= 0)
			pageSize = 10;
		if (pageNumber == null || pageNumber <= 0)
			pageNumber = 1;
		int firstResult = pageNumber * pageSize - pageSize;
		int maxResult = pageSize;
		Query query = em.createNativeQuery(sql).setFirstResult(firstResult).setMaxResults(maxResult);
		if(isMapResult) 
			query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}

	private List<?> getResultListByNativeSql(String sql, List<Object> param, boolean isMapResult) {
		Query query = em.createNativeQuery(sql);
		if (param != null) {
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i + 1, param.get(i));
			}
		}
		if(isMapResult) 
			query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}

	private List<?> getResultListByNativeSql(String sql, List<Object> param, Integer pageSize, Integer pageNumber, boolean isMapResult) {
		if (pageSize == null || pageSize <= 0)
			pageSize = 10;
		if (pageNumber == null || pageNumber <= 0)
			pageNumber = 1;
		int firstResult = pageNumber * pageSize - pageSize;
		int maxResult = pageSize;
		Query query = em.createNativeQuery(sql).setFirstResult(firstResult).setMaxResults(maxResult);
		if (param != null) {
			for (int i = 0; i < param.size(); i++) {
				query.setParameter(i + 1, param.get(i));
			}
		}
		if(isMapResult) 
			query.unwrap(SQLQuery.class).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.getResultList();
	}
	
	private PageData pageQueryByNativeSql(String sql, String sql_count, Integer pageSize, Integer pageNumber, boolean isMapResult) {
		return this.pageQueryByNativeSql(sql, null, sql_count, null, pageSize, pageNumber, isMapResult);
	}

	private PageData pageQueryByNativeSql(String sql, List<Object> param, String sql_count, List<Object> param_count,
			Integer pageSize, Integer pageNumber, boolean isMapResult) {
		List<?> list = this.getResultListByNativeSql(sql, param, pageSize, pageNumber, isMapResult);
		long count = this.getCountByNativeSql(sql_count, param_count);
		return new PageData(list, pageSize, pageNumber, (int)count);
	}

}
