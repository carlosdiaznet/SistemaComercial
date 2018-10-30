package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DIRECCION_ENTREGA")
public class DireccionEntrega implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SC_DIRECCION_ENTREGA_ID")
	@SequenceGenerator(name="SEQ_SC_DIRECCION_ENTREGA_ID", sequenceName="SEQ_SC_DIRECCION_ENTREGA_ID", allocationSize=1)
	private String id;
	
	@Column(name="CALLE", length=200)
	private String calle;
	
	@Column(name="NUMERO", length=100)
	private String numero;
	
	@Column(name="COMPLEMENTO", length=100)
	private String complemento;
	
	@Column(name="CUIDAD", length=100)
	private String ciudad;
	
	@Column(name="DP", length=100)
	private String dp;
	
	@Column(name="CODIGO_POSTAL", length=100)
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DireccionEntrega other = (DireccionEntrega) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
