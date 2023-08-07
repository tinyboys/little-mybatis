package cn.little.mybatis.executor.statement;

import cn.little.mybatis.executor.Executor;
import cn.little.mybatis.executor.resultset.ResultSetHandler;
import cn.little.mybatis.mapping.BoundSql;
import cn.little.mybatis.mapping.MappedStatement;
import cn.little.mybatis.session.Configuration;
import sun.plugin2.main.server.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class BaseStatementHandler implements StatementHandler {

    protected final Configuration configuration;
    private final Executor executor;
    private MappedStatement mappedStatement;


    protected final Object parameterObject;
    protected  final ResultSetHandler resultSetHandler;

    protected BoundSql boundSql;

    public BaseStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, ResultHandler resultHandler, BoundSql boundSql) {
        this.configuration = mappedStatement.getConfiguration();
        this.executor = executor;
        this.mappedStatement = mappedStatement;
        this.boundSql = boundSql;

        this.parameterObject = parameterObject;
        this.resultSetHandler = configuration.newResultSetHandler(executor, mappedStatement, boundSql);
    }

    @Override
    public Statement prepare(Connection connection) throws SQLException {
        Statement statement=null;
        try {
            statement = instantiateStatement(connection);
            statement.setQueryTimeout(350);
            statement.setFetchSize(10000);
            return statement;
        } catch (Exception exception) {
            throw new RuntimeException("Error preparing statement.  Cause: " + exception, exception);
        }
    }

    protected abstract Statement instantiateStatement(Connection connection) throws SQLException;
}
