package cn.little.mybatis.myProxy.bind;

import cn.hutool.core.lang.ClassScanner;
import cn.little.mybatis.myProxy.session.SqlSession;

import java.util.Map;
import java.util.Set;

public class MyRegister {


    private Map<Class<?>,MyProxyFactory<?>> myProxyFactoryMap;



    public void addMappers(String packageName){
        Set<Class<?>> classes = ClassScanner.scanPackage(packageName);
        for (Class<?> aClass : classes) {
            addMapper(aClass);
        }

    }

    private<T> void addMapper(Class<T> aClass) {
        if (aClass.isInterface()){
            if (hasMapper(aClass)) {
                throw new RuntimeException("Type" + aClass + " is already known to the MapperRegistry.");
            } else {
                myProxyFactoryMap.put(aClass, new MyProxyFactory<>(aClass));
            }
        }
    }

    private <T> boolean hasMapper(Class<T> aClass) {
        return myProxyFactoryMap.containsKey(aClass);
    }


    public <T> T getMapper(Class<T> type, SqlSession sqlSession){
        MyProxyFactory<T> mapperProxyFactory =(MyProxyFactory<T>) myProxyFactoryMap.get(type);
        if (mapperProxyFactory==null){
            throw new RuntimeException("Type " + type + "is not known to the MapperRegistry.");
        }
        return mapperProxyFactory.newInstance(sqlSession);
    }
}
