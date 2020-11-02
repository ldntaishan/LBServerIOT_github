package com.cn.httpsms.service;

import com.cn.httpsms.entity.UserOpen;

import java.util.List;

/**
 * Created by ldn on 2019/10/14.
 */
public interface UserOpenService extends BaseService<UserOpen>{

    public void insertUserOpen(UserOpen uo);
    public List<UserOpen> userlogin_use_tel(String loginTag, String userPassWord);
    public List<UserOpen> userlogin_use_email(String loginTag, String userPassWord);

    public UserOpen userlogin(String userOpenId);

}