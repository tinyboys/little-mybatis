package cn.little.mybatis.myProxy.bind;

import cn.little.mybatis.myProxy.session.SqlSession;

import java.lang.reflect.Proxy;

public class MyProxyFactory <T>{

    private Class<T> mapperInterface;

    public MyProxyFactory(Class<T> interfaceType) {
        this.mapperInterface = interfaceType;
    }

    public T newInstance(SqlSession sqlSession){
        MyProxy myProxy = new MyProxy(mapperInterface, sqlSession);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, myProxy);
    }
}
