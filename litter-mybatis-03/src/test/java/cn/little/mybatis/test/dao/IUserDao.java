package cn.little.mybatis.test.dao;

public interface IUserDao {

    String queryUserName(String uId);

    Integer queryUserAge(String uId);

    String queryUserInfoById(String uId);

}
