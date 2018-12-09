package code.pro.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import code.pro.model.Cart;
import code.pro.model.Category;
import code.pro.model.Product;
import code.pro.model.Supplier;
import code.pro.model.UserDetails;

@Configuration
@EnableTransactionManagement
@Component("code.pro")
public class Dbconfig {
	
    @Bean(name="datasource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		datasource.setUsername("root");
		datasource.setPassword("root");
		
		System.out.println("DataSource object created");
		return datasource;
	}
    
    @Bean(name="sessionFactory")
    public SessionFactory getSessionFactory()
    {
    	Properties hibernateproperty= new Properties();
    	
    	hibernateproperty.put("hibernate.hbm2ddl.auto", "update");
    	hibernateproperty.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
    	
    	LocalSessionFactoryBuilder factory = new LocalSessionFactoryBuilder(getH2DataSource());
    	factory.addProperties(hibernateproperty);
    	factory.addAnnotatedClass(Category.class);
    	factory.addAnnotatedClass(Product.class);
    	factory.addAnnotatedClass(UserDetails.class);
    	factory.addAnnotatedClass(Supplier.class);
    	factory.addAnnotatedClass(Cart.class);
    	
    	System.out.println("Session Factory object created");
    	return factory.buildSessionFactory();
    	
    }
	
    @Bean(name="txManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
    {
    	System.out.println("Transaction Manager object created");
		return new HibernateTransactionManager(sessionFactory);
    	
    }
	
}
