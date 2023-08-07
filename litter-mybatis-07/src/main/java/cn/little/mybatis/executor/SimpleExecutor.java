package cn.little.mybatis.executor;

import cn.little.mybatis.executor.statement.StatementHandler;
import cn.little.mybatis.mapping.BoundSql;
import cn.little.mybatis.mapping.MappedStatement;
import cn.little.mybatis.session.Configuration;
import cn.little.mybatis.transaction.Transaction;
import sun.plugin2.main.server.ResultHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SimpleExecutor extends BaseExecutor {

    public SimpleExecutor(Configuration configuration, Transaction transaction) {
        super(configuration, transaction);
    }

    @Override
    protected <E> List<E> doQuery(MappedStatement ms, Object parameter, ResultHandler resultHandler, BoundSql boundSql) {

        try {
            Configuration configuration = ms.getConfiguration();
            StatementHandler handler= configuration.newStatementHandler(this, ms, parameter, resultHandler, boundSql);
            Connection connection = transaction.getConnection();
            Statement stmt = handler.prepare(connection);
            handler.parameterize(stmt);
            return handler.query(stmt, resultHandler);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }


    }

}
