package sv.gob.cnr.sistemacomercial.controller;

import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import sv.gob.cnr.sistemacomercial.entities.Producto;

@Named
@ViewScoped
public class RegistroProductoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	
	public RegistroProductoBean() {
		producto = new Producto();
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public void guardar(){
		throw new RuntimeException("Test de almacenamiento");
	}
	
	
}
