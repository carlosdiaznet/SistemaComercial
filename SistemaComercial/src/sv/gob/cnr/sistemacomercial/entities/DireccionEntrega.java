package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;

public class DireccionEntrega implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String calle;
	private String numero;
	private String complemento;
	private String ciudad;
	private String dp;
	private String codigoPostal;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDp() {
		return dp;
	}
	public void setDp(String dp) {
		this.dp = dp;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	
}
