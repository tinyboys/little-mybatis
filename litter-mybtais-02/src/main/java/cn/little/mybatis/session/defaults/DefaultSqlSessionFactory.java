package cn.little.mybatis.session.defaults;

import cn.little.mybatis.bind.MapperRegistry;
import cn.little.mybatis.session.SqlSession;
import cn.little.mybatis.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;


    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    /**
     * open a session
     * @return the result
     */
    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
