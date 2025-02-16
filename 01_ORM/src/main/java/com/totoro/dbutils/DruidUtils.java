package com.totoro.dbutils;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.dbutils.QueryRunner;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DruidUtils {
    private static final String PROPERTY_PATH = "druid.properties";

    private static DruidDataSource dataSource;
    private static QueryRunner queryRunner;

    public static void init() {
        Properties properties = new Properties();
        // 对于这里读取配置文件的方式可以有两种
        // DruidUtils.class.getClassLoader().getResourceAsStream(classpath下的文件名)
        // DruidUtils.class.getResourceAsStream(/classpath下的文件名)  不加/ 会在这个类所在的包下找资源
        // 加了/  会在classpath下找对应的文件
        InputStream in = DruidUtils.class.getClassLoader().getResourceAsStream(PROPERTY_PATH);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        dataSource = new DruidDataSource();
        dataSource.configFromPropety(properties);
        // 使用数据源初始化 QueryRunner
        queryRunner = new QueryRunner(dataSource);
    }

    public static QueryRunner getQueryRunner() {
        check();
        return queryRunner;
    }

    public static Connection getConnection() {
        check();
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void check() {
        if (dataSource == null || queryRunner == null) {
            throw new RuntimeException("DataSource has not been init");
        }
    }
}
