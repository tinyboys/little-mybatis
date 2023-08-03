package cn.little.mybatis.myProxy.bind;

import cn.little.mybatis.myProxy.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyProxy<T> implements InvocationHandler {

    private final Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MyProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }else {
            return sqlSession.selectOne(method.getName(), args);
        }
    }
}
