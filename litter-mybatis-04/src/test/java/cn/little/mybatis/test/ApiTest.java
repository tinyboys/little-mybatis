package cn.little.mybatis.test;

import cn.little.mybatis.bind.MapperProxyFactory;
import cn.little.mybatis.bind.MapperRegistry;
import cn.little.mybatis.io.Resources;
import cn.little.mybatis.session.SqlSession;
import cn.little.mybatis.session.SqlSessionFactory;
import cn.little.mybatis.session.SqlSessionFactoryBuilder;
import cn.little.mybatis.session.defaults.DefaultSqlSessionFactory;
import cn.little.mybatis.test.dao.IUserDao;
import cn.little.mybatis.test.po.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {


    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_SqlSessionFactory()throws IOException{
        // 1. 从SqlSessionFactory中获取Sqlsession
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config-datasource.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 2. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 3. 测试验证
        User user= userDao.queryUserInfoById(1L);
        logger.info("测试结果：{}", JSON.toJSONString(user));
    }
}
