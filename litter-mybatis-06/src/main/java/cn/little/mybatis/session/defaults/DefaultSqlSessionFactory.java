package cn.little.mybatis.session.defaults;

import cn.little.mybatis.bind.MapperRegistry;
import cn.little.mybatis.executor.Executor;
import cn.little.mybatis.mapping.Environment;
import cn.little.mybatis.session.Configuration;
import cn.little.mybatis.session.SqlSession;
import cn.little.mybatis.session.SqlSessionFactory;
import cn.little.mybatis.session.TransactionIsolationLevel;
import cn.little.mybatis.transaction.Transaction;
import cn.little.mybatis.transaction.TransactionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;


    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /**
     * open a session
     * @return the result
     */
    @Override
    public SqlSession openSession() {
       final Environment environment=configuration.getEnvironment();
        TransactionFactory transactionFactory = environment.getTransactionFactory();
        Transaction transaction = transactionFactory.newTransaction(configuration.getEnvironment().getDataSource(), TransactionIsolationLevel.READ_COMMITTED, false);
        Executor executor = configuration.newExecutor(transaction);
        return new DefaultSqlSession(configuration, executor);
    }
}
