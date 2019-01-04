package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
//import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.entities.Producto2;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;


@ManagedBean(name = "registroProductoMB2")
@ViewScoped
public class RegistroProductoMB2 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository caterorias;
	
	private Producto2 producto;
	
	@Inject
	private Categoria categoria;

	
	
	private List<Categoria> listCategoria;
	
	@PostConstruct
	public void init(){
		this.producto = new Producto2();
	}
	
	public void listarCategorias(){
		this.listCategoria = this.caterorias.listar();
	}
	
	public void onSave() throws Exception{
		try {
			this.producto.setCategoria(categoria);
			System.out.println(this.producto.getSku());
			System.out.println(this.producto.getNombre());
			System.out.println(this.producto.getValorUnitario());
			System.out.println(this.producto.getInventario());
			
			System.out.println("Categoria: " + this.categoria);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Completado"));
			this.producto = new Producto2();
			
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
			throw e;
		}
		
	}

	public Producto2 getProducto() {
		return producto;
	}

	public void setProducto(Producto2 producto) {
		this.producto = producto;
	}

	

	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria =  categoria;
	}
	
}
