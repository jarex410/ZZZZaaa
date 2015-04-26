package test;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Encje.User;

public class bazaDAO {

	public boolean checking (User a){
		
		String query="select  u.Login from Users u";

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("manager");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//entityManager.createQuery(query);  
		entityManager.close();
		entityManagerFactory.close();  
		
		return true;
	}

}
