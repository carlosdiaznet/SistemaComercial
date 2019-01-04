package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CategoriaRepository caterorias;
	
	private Producto producto;
	private Categoria categoria;
	
	private List<Categoria> listCategoria;
	
	@PostConstruct
	public void init(){
		producto = new Producto();
		
	}

	public void inicializar(){
		listCategoria = caterorias.listar();
	}
	
	public void guardar() throws Exception{
		try {
			System.out.println("guardado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Categoria> getListCategoria() {
		return listCategoria;
	}
	
	@NotNull
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
