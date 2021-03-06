package sv.gob.cnr.sistemacomercial.jpa;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EntityManagerProducer {
	private EntityManagerFactory factory;
	
	
	//Constructor
	public EntityManagerProducer() {
		this.factory = Persistence.createEntityManagerFactory("siscomPU");
	}
	
	@Produces
	@RequestScoped
	public EntityManager createEntityManager(){
		return this.factory.createEntityManager();
	}
	
	public void closeEntityManager(@Disposes EntityManager manager){
		manager.close();
	}
}
