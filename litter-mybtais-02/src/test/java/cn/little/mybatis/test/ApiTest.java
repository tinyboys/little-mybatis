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

        // 1.注册Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("cn.little.mybatis.test.dao");

        // 2. 从SqlSession 工厂获取Session
        SqlSessionFactory sqlSessionFactory=new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 获取映射器对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);

        String res = mapper.queryUserName("0001");
        logger.info("测试结果：{}", res);

    }
}
