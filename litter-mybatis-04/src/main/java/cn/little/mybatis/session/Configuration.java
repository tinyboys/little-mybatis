package cn.little.mybatis.session;

import cn.little.mybatis.bind.MapperRegistry;
import cn.little.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.little.mybatis.mapping.Environment;
import cn.little.mybatis.mapping.MappedStatement;
import cn.little.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.little.mybatis.type.TypeAliasRegistry;
import java.util.HashMap;
import java.util.Map;

public class Configuration {

    protected Environment environment;

    protected MapperRegistry mapperRegistry=new MapperRegistry(this);

    // 类型别名注册机
    protected final TypeAliasRegistry typeAliasRegistry = new TypeAliasRegistry();

    public Configuration() {
        typeAliasRegistry.registerAlias("JDBC", JdbcTransactionFactory.class);
        typeAliasRegistry.registerAlias("DRUID", DruidDataSourceFactory.class);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    /**
     * 映射的语句，存在Map里
     */
    protected final Map<String, MappedStatement> mappedStatements = new HashMap<>();

    public void addMappers(String packageName) {
        mapperRegistry.addMappers(packageName);
    }

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        return mapperRegistry.getMapper(type, sqlSession);
    }

    public boolean hasMapper(Class<?> type) {
        return mapperRegistry.hasMapper(type);
    }

    public void addMappedStatement(MappedStatement ms) {
        mappedStatements.put(ms.getId(), ms);
    }

    public MappedStatement getMappedStatement(String id) {
        return mappedStatements.get(id);
    }
    public TypeAliasRegistry getTypeAliasRegistry() {
        return typeAliasRegistry;
    }
}
