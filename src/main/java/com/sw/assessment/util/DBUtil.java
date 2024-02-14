package com.sw.assessment.util;

import lombok.Getter;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class DBUtil {

    @Getter
    private static SqlSessionFactory sqlSessionFactory;

    static {

    }

    @Bean
    public static SqlSessionFactory createConnection() throws Exception{

        try {
            Properties properties = loadProperties("application.properties");

            // Retrieve database properties
            String driver = properties.getProperty("spring.datasource.driver-class-name");
            String url = properties.getProperty("spring.datasource.url");
            String username = properties.getProperty("spring.datasource.username");
            String password = properties.getProperty("spring.datasource.password");

            // Create a PooledDataSource with MariaDB properties
            PooledDataSource dataSource = new PooledDataSource();
            dataSource.setDriver(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);


            SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);
//            sessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath:mapper/*.xml"));
            sqlSessionFactory = sessionFactoryBean.getObject();

            System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }


    private static Properties loadProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = DBUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(inputStream);
        }
        return properties;
    }
}