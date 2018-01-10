package com.seu.dao;

import com.mysql.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SUN on 2017.12.21.
 */
@Component
@PropertySource(value="classpath:DBconfig.properties")
public class DBSetting {
    @Value("${jdbc_url}")
    private String JDBC_URL="jdbc:mysql://223.3.68.10:3306/copyright?characterEncoding=utf8";
    @Value("${jdbc_driverClassName}")
    private String JDBC_DriverClassName;
    @Value("${jdbc_database}")
    private String JDBC_DATABASE;
    @Value("${jdbc_username}")
    private String JDBC_USERNAME="root";
    @Value("${jdbc_password}")
    private String JDBC_PASSWD="root";

    public Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new Driver());
        return DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWD);
    }
}
