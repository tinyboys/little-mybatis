package cn.little.mybatis.bind;

import cn.little.mybatis.session.SqlSession;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapperProxyFactory <T>{

    private final Class<T> mapperInterface;
    private Map<Method, MapperMethod> methodCache = new ConcurrentHashMap<Method, MapperMethod>();


    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }


    /**
     * 新建实例对象内容
     * @param sqlSession sqlSession 实例
     * @return 结果
     */
    @SuppressWarnings("unchecked")
    public T newInstace(SqlSession sqlSession) {
        final MapperProxy<T> tMapperProxy =new MapperProxy<>(sqlSession, mapperInterface,methodCache);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, tMapperProxy);
    }

}
