package sv.gob.cnr.sistemacomercial.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SystemController {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("siscomPU");
	EntityManager em = emf.createEntityManager();
	
	public SystemController() {
		
	}
	
	
	
	

}
