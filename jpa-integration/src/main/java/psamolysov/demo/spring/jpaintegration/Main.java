package psamolysov.demo.spring.jpaintegration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import psamolysov.demo.spring.jpaintegration.service.SimpleService;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		// Demo how Spring Framework manages transactions and uses JPA
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringCommonConfiguration.class);
		
		SimpleService service = ctx.getBean(SimpleService.class);
		service.persistme();
		
		System.out.println("A record has been inserted");
		
		// Let me check if the record exists in the database		
		EntityManagerFactory emf = new SpringCommonConfiguration()
				.buildEntityManagerFactory();
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Connection con = em.unwrap(Connection.class);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM MYENTITY ORDER BY ID");
		while (rs.next()) {
			System.out.println("ID: " + rs.getString("ID") + 
					", NAME: " + rs.getString("NAME"));
		}
		em.getTransaction().commit();
		em.close();
		
		// Shutdown internal Derby db
		try {
			DriverManager.getConnection("jdbc:derby:;shutdown=true");
		} catch (SQLException e) {
			if ("XJ015".equals(e.getSQLState())) {
				System.out.println("Derby has been successfully shutdown");
			} else {
				throw e;
			}
		}
	}
}
