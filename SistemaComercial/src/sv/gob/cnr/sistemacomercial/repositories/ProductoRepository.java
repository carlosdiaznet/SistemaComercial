package sv.gob.cnr.sistemacomercial.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.filter.ProductoFilter;

public class ProductoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Producto> listarProductos(){
		return manager.createQuery("select p from Producto p", Producto.class).getResultList();
	}
	
	public List<Producto> filtrados(ProductoFilter filtro){
		return null;
	}
	
	public Producto porSku(String sku){
		try {
			return manager.createQuery("select p from Producto p where upper(p.sku) = :sku", Producto.class)
					.setParameter("sku", sku.toUpperCase()).getSingleResult();
					
		} catch (NoResultException e) {
			return null;
		}
	}

}
