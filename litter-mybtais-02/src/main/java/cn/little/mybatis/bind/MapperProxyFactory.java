package cn.little.mybatis.bind;

import cn.little.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

public class MapperProxyFactory <T>{

    private final Class<T> mapperInterface;


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
        final MapperProxy<T> tMapperProxy =new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, tMapperProxy);
    }

}
