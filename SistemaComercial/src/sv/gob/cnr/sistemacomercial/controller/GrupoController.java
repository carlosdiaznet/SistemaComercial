package sv.gob.cnr.sistemacomercial.controller;

import sv.gob.cnr.sistemacomercial.entities.Grupo;

public class GrupoController extends SystemController {

	public GrupoController() {

	}
	
	public void registrarGrupo(Grupo grupo){
		transaccion.begin();
		em.persist(grupo);
		transaccion.commit();
	}
}
