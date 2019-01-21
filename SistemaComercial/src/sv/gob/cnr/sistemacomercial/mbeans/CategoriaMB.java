package sv.gob.cnr.sistemacomercial.mbeans;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import sv.gob.cnr.sistemacomercial.controller.CategoriaController;
import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

@ManagedBean(name = "categoriaMB")
@ViewScoped
public class CategoriaMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Categoria categoria;
	
	private List<Categoria> listCategoria;
	
	@Inject
	private CategoriaRepository caterorias;
	
	@Inject
	private CategoriaRepository cat;
	

	@PostConstruct
	public void init(){
		 categoria = new Categoria();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Categoria objCategoria(Long id){
		return cat.byId(id);
	}
	
	public void inicializar(){
		listCategoria = caterorias.listar();	
		
	}
	
	public List<Categoria> getListCategoria() {
		return listCategoria;
	}
	
	public String clear(){
		
		return "registroCategoria.xhtml?faces-redirect=true";
	}
	
	public void registrar() throws Exception{
		CategoriaController reg;
		try {
			reg = new CategoriaController();
			reg.registrarCategoria(categoria);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Completado"));
			this.categoria = new Categoria();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
			throw e;
			
		}
	}
}
