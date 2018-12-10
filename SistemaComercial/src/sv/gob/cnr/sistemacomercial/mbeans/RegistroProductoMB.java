package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.entities.Producto;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	
	private List<Categoria> listCategoria;
	
	public RegistroProductoMB(){
		producto = new Producto();
	}
	
	public void inicializar(){
		System.out.println("Inicializando lista...");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("siscomPU");
		EntityManager manager = factory.createEntityManager();
		
		listCategoria = manager.createQuery("select c from Categoria c", Categoria.class).getResultList();
		manager.close();
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
