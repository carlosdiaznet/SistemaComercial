package sv.gob.cnr.sistemacomercial.mbeans;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.sistemacomercial.controller.CategoriaController;
import sv.gob.cnr.sistemacomercial.entities.Categoria;

@ManagedBean(name = "categoriaMB")
@ViewScoped
public class CategoriaMB {
	private Categoria categoria;
	
	

	public CategoriaMB() {
		categoria = new Categoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void registrar() throws Exception{
		CategoriaController reg;
		try {
			reg = new CategoriaController();
			reg.registrarCategoria(categoria);
		} catch (Exception e) {
			throw e;
		}
	}
}
