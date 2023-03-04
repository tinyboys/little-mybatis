package cn.little.mybatis.test;

import cn.little.mybatis.bind.MapperProxyFactory;
import cn.little.mybatis.bind.MapperRegistry;
import cn.little.mybatis.session.SqlSession;
import cn.little.mybatis.session.SqlSessionFactory;
import cn.little.mybatis.session.defaults.DefaultSqlSessionFactory;
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


    }
}
