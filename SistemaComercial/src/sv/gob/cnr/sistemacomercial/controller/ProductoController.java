package sv.gob.cnr.sistemacomercial.controller;

import sv.gob.cnr.sistemacomercial.entities.Producto;

public class ProductoController extends SystemController{

	public ProductoController() {
		
	}
	
	public void registrarProducto(Producto producto){
		transaccion.begin();
			em.merge(producto);
		transaccion.commit();
	}
	
	public Producto productoID(Producto producto) throws Exception {
		transaccion.begin();
			Producto prd = em.find(Producto.class, producto.getId());
		transaccion.commit();
		return prd;
	}

}
