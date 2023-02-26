package cn.little.mybatis.bind;

import java.lang.reflect.Proxy;
import java.util.Map;

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
    public T newInstace(Map<String,String>sqlSession) {
        MapperProxy<T> tMapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, tMapperProxy);
    }

}
