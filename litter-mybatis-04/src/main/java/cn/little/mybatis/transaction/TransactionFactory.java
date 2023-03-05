package cn.little.mybatis.transaction;

import cn.little.mybatis.session.TransactionIsolationLevel;

import javax.sql.DataSource;
import java.sql.Connection;

public interface TransactionFactory {


    /**
     * create transaction by Connection
     * @param connection connection
     * @return return transaction
     */
    Transaction newTransaction(Connection connection);


    /**
     * create transaction with datasource
     * @param dataSource datasource
     * @param level commite level ,see {@link TransactionIsolationLevel}
     * @param autoCommit if you  want to commit automatically,set the parameter true,else set false
     * @return
     */
    Transaction newTransaction(DataSource dataSource, TransactionIsolationLevel level, boolean autoCommit);

}
