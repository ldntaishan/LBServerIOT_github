package com.cn.httpsms.service;

import com.cn.httpsms.entity.UserBase;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by ldn on 2017/10/24.
 */
public interface UserBaseService extends BaseService<UserBase>{

    public void insertUserBase(UserBase ub);
    public void updateUserBase(UserBase ub);
    public void deleteUserBase(String userBaseId);
    public JSONObject se_UserBase(String key, String value);
    public List<UserBase> userlogin(String loginTag, String userPassWord);
    public List<UserBase> list_all_userBase();
    public List<UserBase> list_query_userBase(int pageSize,int pageNum);
    public long list_count_userBase();

}
