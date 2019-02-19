package sv.gob.cnr.sistemacomercial.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.filter.ProductoFilter;

public class ProductoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Producto> listarProductos(){
		return manager.createQuery("select p from Producto p", Producto.class).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Producto> filtrados(ProductoFilter filtro){
		if(filtro.getSku() != null && filtro.getNombre() != null){
			Query query = manager.createQuery("SELECT p FROM Producto p WHERE p.sku LIKE %:sku% OR p.nombre LIKE %:nombre%", Producto.class);
				query.setParameter("sku", filtro.getSku());
				query.setParameter("nombre", filtro.getNombre());
				return query.getResultList();
		} else {
			return null;
		}
		
		
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
