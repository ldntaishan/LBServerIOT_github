package com.cn.httpsms.service.impl;


import com.cn.httpsms.entity.Product;
import com.cn.httpsms.entity.UserBase;
import com.cn.httpsms.service.UserBaseService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by ldn on 2017/10/24.
 */

@Service
@Transactional
public class UserBaseServiceImpl extends BaseServiceImpl<UserBase> implements UserBaseService {

    @Override
    public void insertUserBase(UserBase ub) {
        insert(ub);
    }

    @Override
    public void updateUserBase(UserBase ub) {
        update(ub);
    }

    @Override
    public JSONObject se_UserBase(String key, String value) {
        String sql = "select ub from UserBase ub where ub."+key+"='"+value+"'";
        List<?> list = getResultList(sql);
        UserBase ub=new UserBase();
        JSONObject userBaseJSON = new JSONObject();
        if(list.size()!=0){
            ub=(UserBase) list.get(0);
            userBaseJSON.put("userId",ub.getUserId());
            userBaseJSON.put("userName",ub.getUserName());
            userBaseJSON.put("userNickName",ub.getUserNickName());
            userBaseJSON.put("userEmail",ub.getUserEmail());
            userBaseJSON.put("userTel",ub.getUserTel());
            userBaseJSON.put("userPassWord",ub.getUserPassWord());
            userBaseJSON.put("userState",ub.getUserState());
            userBaseJSON.put("lastLoginTime",ub.getLastLoginTime());
            userBaseJSON.put("createdate",ub.getCreatedate());
            userBaseJSON.put("changedate",ub.getChangedate());

        }

        return userBaseJSON;
    }

    @Override
    public List<UserBase> userlogin(String loginTag,String userPassWord)
    {
        String sql = "select ub from UserBase ub where ub.userTel='"+loginTag+"' and ub.userPassWord='"+userPassWord+"'";
        List<UserBase> list = getResultList(sql);
        return list;
    }

    /**
     * 根据创建时间查询全部
     * //无条件查询前100条数据
     * @return
     */
    @Override
    public List<UserBase> list_all_userBase()
    {
        String list_all_userBase_Sql = "select pd from UserBase pd order by pd.createdate DESC";
        List<UserBase> list_userBase = getResultList(list_all_userBase_Sql);
        return list_userBase;
    }

    @Override
    public void deleteUserBase(String userBaseId)
    {
        deleteById(userBaseId);
    }



}
