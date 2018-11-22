package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.sistemacomercial.entities.Producto;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	
	RegistroProductoMB(){
		producto = new Producto();
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
	
	
}
