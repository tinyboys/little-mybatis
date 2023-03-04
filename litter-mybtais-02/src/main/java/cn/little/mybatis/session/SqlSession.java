package cn.little.mybatis.session;


/**
 *
 */
public interface SqlSession {


    /**
     *  Retrieve a single row mapped from the statement key
     * @param statement  sqlID
     * @param <T> the returned object type
     * @return Mapped object
     */
    <T> T selectOne(String statement);

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * @param statement Unique identifier matching the statement to use.
     * @param parameter A parameter object to pass to the statement
     * @param <T> the returned object type
     * @return
     */
    <T> T selectOne(String statement,Object parameter);


    /**
     * Retrieves a mapper
     * @param type the mapper type
     * @param <T> Mapper interface class
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);
}
