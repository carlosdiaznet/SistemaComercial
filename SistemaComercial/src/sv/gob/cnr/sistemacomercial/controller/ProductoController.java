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
	

}
