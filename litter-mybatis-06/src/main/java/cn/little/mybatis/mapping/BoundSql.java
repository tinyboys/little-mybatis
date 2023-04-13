package cn.little.mybatis.mapping;

import java.util.Map;

public class BoundSql {

    private String sql;
    private Map<Integer,String> paramterMappings;
    private String parameterType;
    private String resultType;


    public BoundSql(String sql, Map<Integer, String> parameterMappings, String parameterType, String resultType) {
        this.sql = sql;
        this.paramterMappings = parameterMappings;
        this.parameterType = parameterType;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Map<Integer, String> getParamterMappings() {
        return paramterMappings;
    }

    public void setParamterMappings(Map<Integer, String> paramterMappings) {
        this.paramterMappings = paramterMappings;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
