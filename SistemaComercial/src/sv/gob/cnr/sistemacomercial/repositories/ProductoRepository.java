package sv.gob.cnr.sistemacomercial.repositories;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import sv.gob.cnr.sistemacomercial.entities.Producto;

public class ProductoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Producto porSku(String sku){
		try {
			return manager.createQuery("select p from Producto p where upper(sku) = :sku", Producto.class)
					.setParameter("sku", sku.toUpperCase()).getSingleResult();
					
		} catch (NoResultException e) {
			return null;
		}
	}

}
