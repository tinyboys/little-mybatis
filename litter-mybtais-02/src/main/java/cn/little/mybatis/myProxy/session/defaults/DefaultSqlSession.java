package cn.little.mybatis.myProxy.session.defaults;

import cn.little.mybatis.myProxy.bind.MyRegister;
import cn.little.mybatis.myProxy.session.SqlSession;

public class DefaultSqlSession implements SqlSession {

    private MyRegister myRegister;

    public DefaultSqlSession(MyRegister myRegister) {
        this.myRegister = myRegister;
    }

    /**
     * 获取一个注册
     * @param type
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> type) {
      return (T) myRegister.getMapper(type,this);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }
}
