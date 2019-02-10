package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
//import java.util.List;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	private Categoria categoria;
	private CategoriaRepository repository;
	
	private List<Categoria> subCategoria;
		
	@PostConstruct
	public void init(){
		this.producto = new Producto();
				
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public void loadSubcategorias(){
		subCategoria = repository.subCategorias(categoria);
	}
	
	

	public List<Categoria> getSubCategoria() {
		return subCategoria;
	}

	public void guardar() throws Exception{
		try {
			System.out.println("Categoria: " + this.categoria.getNombre());
			System.out.println("SubCategoria: " + this.producto.getCategoria().getNombre());
		} catch (Exception e) {

		}
		
	} 
	
	private boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
/*	public Categoria getCategoria(Long id){
		if(id == null){
			throw new IllegalArgumentException("Id no ingresado");
		}
		this.repository = new CategoriaRepository();
		return repository.byId(id);
	}*/
	
}
