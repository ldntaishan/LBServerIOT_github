package com.cn.httpsms.dao.impl;

import com.cn.httpsms.dao.JpaBaseDao;
import com.cn.httpsms.util.PageData;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

/**
 * @param <T> POJO泛型信息
 * @author liu.songgao
 *         <p>创建时间: 2015年5月7日 下午1:37:38</p>
 *         <p>描述：jpa基础操作实现类</p>
 * @version 1.0
 */
@Repository("jpaBaseDao")
public  abstract class JpaBaseDaoImpl<T extends Serializable> implements JpaBaseDao<T> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> entityClass;

    @SuppressWarnings("unchecked")
    public JpaBaseDaoImpl() {
        ResolvableType resolvableType1 = ResolvableType.forClass(this.getClass());
        entityClass = (Class<T>) resolvableType1.getSuperType().getGeneric(0).resolve();
    }

    @Override
    public void insert(T entity) {
        em.persist(entity);
    }

    @Override
    public void update(T entity) {
        em.merge(entity);
    }

    @Override
    public void delete(T entity) {
        em.remove(entity);
    }

    @Override
    public void deleteById(Object id) {
        em.remove(em.getReference(entityClass, id));
    }

    @Override
    public T find(Object key) {
        return em.find(entityClass, key);
    }

    @Override
    public T find(Class<T> clazz, Object key) {
        return em.find(clazz, key);
    }

    @Override
    public void batchInsert(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            em.persist(list.get(i));
            if ((i + 1) % 50 == 0 || (i + 1) == list.size()) {
                em.flush();
            }
        }
    }

    @Override
    public void batchUpdate(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            em.merge(list.get(i));
            if ((i + 1) % 50 == 0 || (i + 1) == list.size()) {
                em.flush();
            }
        }
    }

    @Override
    public void batchDelete(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            em.remove(list.get(i));
            if ((i + 1) % 50 == 0 || (i + 1) == list.size()) {
                em.flush();
            }
        }
    }

    @Override
    public void batchDeleteByIds(Object[] ids) {
        for (Object id : ids) {
            deleteById(id);
        }
    }

    @Override
    public List<T> getResultList(String hql) {
        return em.createQuery(hql).getResultList();
    }

    @Override
    public List<T> getResultList(String hql, Integer pageSize, Integer pageNumber) {
        if (pageSize == null || pageSize <= 0)
            pageSize = 10;
        if (pageNumber == null || pageNumber <= 0)
            pageNumber = 1;
        int firstResult = pageNumber * pageSize - pageSize;
        int maxResult = pageSize;
        return em.createQuery(hql).setFirstResult(firstResult).setMaxResults(maxResult).getResultList();
    }

    @Override
    public List<T> getResultList(String hql, List<Object> param) {
        Query query = em.createQuery(hql);
        if (param != null) {
            for (int i = 0; i < param.size(); i++) {
                query.setParameter(i + 1, param.get(i));
            }
        }
        return query.getResultList();
    }

    @Override
    public List<T> getResultList(String hql, List<Object> param, Integer pageSize, Integer pageNumber) {
        if (pageSize == null || pageSize <= 0)
            pageSize = 10;
        if (pageNumber == null || pageNumber <= 0)
            pageNumber = 1;
        int firstResult = pageNumber * pageSize - pageSize;
        int maxResult = pageSize;
        Query query = em.createQuery(hql).setFirstResult(firstResult).setMaxResults(maxResult);
        if (param != null && param.size() > 0) {
            for (int i = 0, n = param.size(); i < n; i++) {
                query.setParameter(i + 1, param.get(i));
            }
        }
        return query.getResultList();
    }

    @Override
    public long getCountByHql(String hql) {
        return (Long) em.createQuery(hql).getSingleResult();
    }

    @Override
    public long getCountByHql(String hql, List<Object> param) {
        Query query = em.createQuery(hql);
        if (param != null && param.size() > 0) {
            for (int i = 0, n = param.size(); i < n; i++) {
                query.setParameter(i + 1, param.get(i));
            }
        }
        return (Long) query.getSingleResult();
    }

    @Override
    public PageData pageQuery(String hql, String hql_count, Integer pageSize, Integer pageNumber) {
        return this.pageQuery(hql, null, hql_count, null, pageSize, pageNumber);
    }

    @Override
    public PageData pageQuery(String hql, List<Object> param, String hql_count, List<Object> param_count, Integer pageSize, Integer pageNumber) {
        List<?> list = this.getResultList(hql, param, pageSize, pageNumber);
        long count = this.getCountByHql(hql_count, param_count);
        return new PageData(list, pageSize, pageNumber, (int) count);
    }

    @Override
    public void flush() {
        em.flush();
    }

    @Override
    public void detach(T entity) {
        em.detach(entity);
    }

    @Override
    public boolean contains(T entity) {
        return em.contains(entity);
    }

    @Override
    public Class<T> getEntityClass() {
        return this.entityClass;
    }
}
