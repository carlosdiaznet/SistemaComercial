package sv.gob.cnr.sistemacomercial.filter;

import java.io.Serializable;

import sv.gob.cnr.sistemacomercial.validation.SKU;

public class ProductoFilter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	
	@SKU
	private String sku;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku == null ? null : sku.toUpperCase();
	}
	
	

}
