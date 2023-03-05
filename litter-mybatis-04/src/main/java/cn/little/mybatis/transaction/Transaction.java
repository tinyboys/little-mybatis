package cn.little.mybatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;

public interface Transaction {

    /**
     * get Connection
     * @return result
     * @throws SQLException
     */
    Connection getConnection()throws SQLException;


    /**
     * commit transaction
     * @throws SQLException sql exception
     */
    void commit() throws SQLException;


    /**
     * rollback transaction
     * @throws SQLException transaction exception
     */
    void rollback() throws SQLException;


    /**
     * close transaction
     * @throws SQLException transaction exception
     */
    void close()throws SQLException;
}
