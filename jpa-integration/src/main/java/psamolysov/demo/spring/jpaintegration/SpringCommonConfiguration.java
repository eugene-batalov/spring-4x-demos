package psamolysov.demo.spring.jpaintegration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import psamolysov.demo.spring.jpaintegration.service.SimpleService;
import psamolysov.demo.spring.jpaintegration.service.jpa.JPASimpleService;

/**
 * A Spring Framework configuration. Transactions demarcation must be configured
 * using the {@link org.springframework.transaction.annotation.Transactional} 
 * annotation.
 * 
 * @author Pavel Samolysov
 * @see org.springframework.transaction.annotation.Transactional
 */
@Configuration
@EnableTransactionManagement
public class SpringCommonConfiguration {

	public static final String PERSISTENCE_UNIT = "jpa-integration"; 

	@Bean
	public EntityManagerFactory buildEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
	}
	
	@Bean
	public SimpleService buildSimpleService() {
		return new JPASimpleService();
	}
	
	@Bean
	public PlatformTransactionManager buildTxManager() {
		return new JpaTransactionManager(buildEntityManagerFactory());
	}
}
