package com.cn.httpsms.service.impl;

import com.cn.httpsms.entity.UserOpen;
import com.cn.httpsms.service.UserOpenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ldn on 2019/10/14.
 */
@Service
@Transactional
public class UserOpenServiceImpl extends BaseServiceImpl<UserOpen> implements UserOpenService {

    @Override
    public void insertUserOpen(UserOpen uo) {
        insert(uo);
    }

    @Override
    public List<UserOpen> userlogin_use_tel(String loginTag, String userPassWord)
    {
        String sql = "select uo from UserOpen uo where uo.userOpenTel='"+loginTag+"' and uo.userOpenPassWord='"+userPassWord+"'";
        List<UserOpen> list = getResultList(sql);
        return list;
    }

    @Override
    public List<UserOpen> userlogin_use_email(String loginTag, String userPassWord)
    {
        String sql = "select uo from UserOpen uo where uo.userOpenEmail='"+loginTag+"' and uo.userOpenPassWord='"+userPassWord+"'";
        List<UserOpen> list = getResultList(sql);
        return list;
    }

    @Override
    public UserOpen userlogin(String userOpenId)
    {
        return  find(userOpenId);
    }

}
