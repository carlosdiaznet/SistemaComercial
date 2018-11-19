package sv.gob.cnr.sistemacomercial.mbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.sistemacomercial.entities.Producto;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB {
	
	private Producto producto;
	
	RegistroProductoMB(){
		producto = new Producto();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
}
