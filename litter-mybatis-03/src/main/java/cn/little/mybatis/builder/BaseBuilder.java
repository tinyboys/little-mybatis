package cn.little.mybatis.builder;

import cn.little.mybatis.session.Configuration;

public abstract class BaseBuilder {
    protected final Configuration configuration;

    public Configuration getConfiguration() {
        return configuration;
    }

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }
}
