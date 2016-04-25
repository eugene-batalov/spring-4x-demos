package psamolysov.demo.spring.jpaintegration.service.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import psamolysov.demo.spring.jpaintegration.entity.MyEntity;
import psamolysov.demo.spring.jpaintegration.service.SimpleService;

public class JPASimpleService implements SimpleService {

	@PersistenceContext
	private EntityManager em;
		
	@Override
	@Transactional
	public void persistme() {		
		em.persist(new MyEntity(Thread.currentThread().getName()));
	}	
}
