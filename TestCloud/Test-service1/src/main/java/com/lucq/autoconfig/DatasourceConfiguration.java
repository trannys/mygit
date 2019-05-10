package com.lucq.autoconfig;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.lucq.properties.DataSourceProperties;

@Configuration
@ConditionalOnClass(DataSourceProperties.class)
@EnableConfigurationProperties(DataSourceProperties.class)
public class DatasourceConfiguration {
	
	@Autowired
	private DataSourceProperties dataSourceProperties;

	@Bean
	public DataSource druidDataSource() {
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(dataSourceProperties.getUrl());
		datasource.setUsername(dataSourceProperties.getUsername());        
		datasource.setPassword(dataSourceProperties.getPassword());       
		datasource.setDriverClassName(dataSourceProperties.getDriverClassName());        
		datasource.setInitialSize(dataSourceProperties.getInitialSize());       
		datasource.setMinIdle(dataSourceProperties.getMinIdle());        
		datasource.setMaxActive(dataSourceProperties.getMaxActive());       
		datasource.setMaxWait(dataSourceProperties.getMaxWait());        
		datasource.setTimeBetweenEvictionRunsMillis(dataSourceProperties.getTimeBetweenEvictionRunsMillis());        
		datasource.setMinEvictableIdleTimeMillis(dataSourceProperties.getMinEvictableIdleTimeMillis());        
		datasource.setValidationQuery(dataSourceProperties.getValidationQuery());        
		datasource.setTestWhileIdle(dataSourceProperties.getTestWhileIdle());        
		datasource.setTestOnBorrow(dataSourceProperties.getTestOnBorrow());
		datasource.setTestOnReturn(dataSourceProperties.getTestOnReturn());
		
		try {
			datasource.setFilters(dataSourceProperties.getFilters());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return datasource;
	}
}
