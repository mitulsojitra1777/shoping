package com.srinathji.shopngback.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.srinathji.shopngback.dto"})
@EnableTransactionManagement
public class HibernateConfig {
	private static final String DATABASE_URL="jdbc:h2:tcp://localhost/~/shoping";
	private static final String DATABASE_DRIVER="org.h2.Driver";
	private static final String DATABASE_USERNAME="sa";
	private static final String DATABASE_PASSWORD="";
	private static final String DATABASE_DILECT="org.hibernate.dialect.H2Dialect";
	
	@Bean
	public DataSource getDatrsource(){
		BasicDataSource dataSource=new BasicDataSource();
		
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;
		
	}
	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder= new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("com.srinathji.shopngback.dto");		
		return builder.buildSessionFactory();
		
		
	}

	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DILECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		return properties;
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory factory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(factory);
		
		return transactionManager;
		
	}

}
