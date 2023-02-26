package cn.little.mybatis.test;

import cn.little.mybatis.bind.MapperProxyFactory;
import cn.little.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {


    private Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Test
    public void test_MapperProxyFactory(){
        // 代理工厂
        MapperProxyFactory<IUserDao> factory=new MapperProxyFactory<>(IUserDao.class);
        // 装配SqlSession内容
        Map<String,String> sqlSession=new HashMap<>();
        sqlSession.put("cn.little.mybatis.test.dao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("cn.little.mybatis.test.dao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        // 获取sqlSession
        IUserDao iUserDao = factory.newInstace(sqlSession);
        // 获取执行内容
        String res = iUserDao.queryUserName("10001");
        logger.info("测试结果{}",res);
    }

    @Test
    public void test_proxy_class(){
        IUserDao userDao  = (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, (proxy, method, args) -> "你被代理了！");
        String result = userDao.queryUserName("10001");
        System.out.println("测试结果：" + result);
    }
}
