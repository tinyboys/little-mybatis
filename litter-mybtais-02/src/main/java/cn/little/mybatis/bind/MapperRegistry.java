package cn.little.mybatis.bind;

import cn.hutool.core.lang.ClassScanner;
import cn.little.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapperRegistry {


    private final Map<Class<?>,MapperProxyFactory<?>>knownMappers=new HashMap<>();


    /**
     *  get Mapper
     * @param type
     * @param sqlSession
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
      final MapperProxyFactory<T> mapperProxyFactory= (MapperProxyFactory<T>) knownMappers.get(type);
      if (mapperProxyFactory==null){
          throw new RuntimeException("Type " + type + "is not known to the MapperRegistry.");
      }
        try {
            return mapperProxyFactory.newInstace(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance. Cause: " + e, e);
        }
    }


    /**
     * addMapper by Type
     * @param type type
     * @param <T>
     */
    public <T> void addMapper(Class<T> type){
        if (type.isInterface()){
            if (hasMapper(type)){
                throw new RuntimeException("Type" + type + " is already known to the MapperRegistry.");
            }
            knownMappers.put(type,new MapperProxyFactory<>(type));
        }
    }


    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }


    public void addMappers(String packageName) {
        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }
    }

}
