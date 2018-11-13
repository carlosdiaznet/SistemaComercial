package sv.gob.cnr.sistemacomercial.controller;

import sv.gob.cnr.sistemacomercial.entities.Categoria;

public class CategoriaController extends SystemController {
	
	public CategoriaController() {
		
	}

	public void registrarCategoria(Categoria ctga){
		transaccion.begin();
		em.persist(ctga);
		transaccion.commit();
	}
	
}
