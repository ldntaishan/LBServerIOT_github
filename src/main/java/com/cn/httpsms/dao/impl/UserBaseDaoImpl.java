package com.cn.httpsms.dao.impl;


import com.cn.httpsms.dao.UserBaseDao;
import com.cn.httpsms.entity.UserBase;
import org.springframework.stereotype.Repository;

/**
 * Created by ldn on 2017/10/24.
 */
@Repository
public class UserBaseDaoImpl extends JpaBaseDaoImpl<UserBase> implements UserBaseDao {
}
