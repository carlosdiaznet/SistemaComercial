package sv.gob.cnr.sistemacomercial.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.sistemacomercial.controller.GrupoController;
import sv.gob.cnr.sistemacomercial.entities.Grupo;

@ManagedBean(name = "grupoMB")
@ViewScoped
public class GrupoMB {
	private Grupo grupo;
	
	public GrupoMB() {
		grupo = new Grupo();
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	public void registrar() throws Exception {
		GrupoController reg;
		try {
			reg = new GrupoController();
			reg.registrarGrupo(grupo);
		} catch (Exception e) {
			throw e;
		}
	}
}
