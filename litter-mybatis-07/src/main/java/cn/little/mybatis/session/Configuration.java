package cn.little.mybatis.session;

import cn.little.mybatis.bind.MapperRegistry;
import cn.little.mybatis.datasource.druid.DruidDataSourceFactory;
import cn.little.mybatis.executor.Executor;
import cn.little.mybatis.executor.SimpleExecutor;
import cn.little.mybatis.executor.resultset.DefaultResultSetHandler;
import cn.little.mybatis.executor.resultset.ResultSetHandler;
import cn.little.mybatis.executor.statement.PreparedStatementHandler;
import cn.little.mybatis.executor.statement.StatementHandler;
import cn.little.mybatis.mapping.BoundSql;
import cn.little.mybatis.mapping.Environment;
import cn.little.mybatis.mapping.MappedStatement;
import cn.little.mybatis.transaction.Transaction;
import cn.little.mybatis.transaction.jdbc.JdbcTransactionFactory;
import cn.little.mybatis.type.TypeAliasRegistry;
import sun.plugin2.main.server.ResultHandler;

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

    /**
     * 创建结果集处理器
     */
    public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, BoundSql boundSql) {
        return new DefaultResultSetHandler(executor, mappedStatement, boundSql);
    }

    /**
     * 生产执行器
     */
    public Executor newExecutor(Transaction transaction) {
        return new SimpleExecutor(this, transaction);
    }

    /**
     * 创建语句处理器
     */
    public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {
        return new PreparedStatementHandler(executor, mappedStatement, parameter, resultHandler, boundSql);
    }
}
