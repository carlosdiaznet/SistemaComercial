package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
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
	
	private List<Categoria> listCategoria;
	
	public RegistroProductoMB(){
		producto = new Producto();
	}
	
	public void inicializar(){
		System.out.println("Inicializando lista...");
		listCategoria = caterorias.listar();
	}
	
	public void guardar(){
		throw new RuntimeException("Test de almacenamiento");
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
}
