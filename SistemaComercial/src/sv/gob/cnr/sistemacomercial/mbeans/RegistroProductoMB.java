package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.gob.cnr.sistemacomercial.entities.Producto;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
		
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
	
}
