package cn.little.mybatis.builder;

import cn.little.mybatis.session.Configuration;
import cn.little.mybatis.type.TypeAliasRegistry;

public abstract class BaseBuilder {
    protected final Configuration configuration;
    protected final TypeAliasRegistry typeAliasRegistry;

    public Configuration getConfiguration() {
        return configuration;
    }

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
        this.typeAliasRegistry=this.configuration.getTypeAliasRegistry();
    }
}
