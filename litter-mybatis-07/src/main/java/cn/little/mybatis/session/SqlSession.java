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
     * Retrieves current configuration
     * 得到配置
     * @return Configuration
     */
    Configuration getConfiguration();

    /**
     * Retrieves a mapper.
     * 得到映射器，这个巧妙的使用了泛型，使得类型安全
     *
     * @param <T>  the mapper type
     * @param type Mapper interface class
     * @return a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);
}
