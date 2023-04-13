package cn.little.mybatis.test.dao;

import cn.little.mybatis.test.po.User;

public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

    User queryUserInfoById(Long uId);

}
