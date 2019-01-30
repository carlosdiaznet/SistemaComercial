package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	private CategoriaRepository repository;
		
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
	
	public void guardar() throws Exception{
		try {
			System.out.println("Categoria: " + producto.getCategoria().getNombre());
		} catch (Exception e) {

		}
		
	} 
	
	public Categoria getCategoria(Long id){
		if(id == null){
			throw new IllegalArgumentException("Id no ingresado");
		}
		this.repository = new CategoriaRepository();
		return repository.byId(id);
	}
	
}
