package com.cn.httpsms.dao;

import com.cn.httpsms.util.PageData;

import java.io.Serializable;
import java.util.List;

/**
 * @author liu.songgao
 * <p>创建时间: 2015年5月7日 下午1:37:13</p>
 * <p>描述：jpa基础操作接口,基于原生sql</p>
 * @version 1.0
 */
public interface JpaNativeBaseDao extends Serializable {
	
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
	
}
