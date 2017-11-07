package com.dy.bulletscreen.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.Properties;

/**
 * 描述：不使用spring容器，基本baseDAO<br>
 * 版权：Copyright (c) 2011 ~ 2017<br>
 * 公司：北京活力天汇<br>
 * 作者：刘德咏<br>
 * 版本：1.0<br>
 * 创建日期：2017/11/6<br>
 */
public class BaseDao extends JdbcDaoSupport {
    private Logger logger = LoggerFactory.getLogger(BaseDao.class);
    @Override
    protected void initTemplateConfig() {
        super.initTemplateConfig();
    }

    @Override
    protected JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        ComboPooledDataSource dataSource1 = new ComboPooledDataSource();
        // 加载配置文件
        Properties p;
        try {
            p = new Properties();
            p.load(getClass().getClassLoader().getResourceAsStream("const.properties"));
            dataSource1.setDriverClass(p.getProperty("mysql.driverClass"));
            dataSource1.setUser(p.getProperty("mysql.username"));
            dataSource1.setPassword(p.getProperty("mysql.password"));
            dataSource1.setJdbcUrl(p.getProperty("mysql.url"));
//            dataSource1.setMaxPoolSize(200);
//            dataSource1.setInitialPoolSize(100);
//            dataSource1.setMinPoolSize(100);
            dataSource1.setMaxIdleTime(200);
            dataSource1.setMaxConnectionAge(180);
        } catch (IOException e) {
            logger.error("{}", e);
            e.printStackTrace();
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return super.createJdbcTemplate(dataSource1);
    }


    @Override
    protected void initDao() throws Exception {
        super.initDao();
    }
}
