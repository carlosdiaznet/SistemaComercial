package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SC_DIRECCION")
public class Direccion implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_DIRECCION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SC_DIRECCION_ID")
	@SequenceGenerator(name="SEQ_SC_DIRECCION_ID", sequenceName="SEQ_SC_DIRECCION_ID", allocationSize=1)
	private long id;
	
	@Column(name="CALLE", nullable=false, length=150)
	private String calle;
	
	@Column(name="NUMERO", nullable=false, length=150)
	private String numero;
	
	@Column(name="COMPLEMENTO", length=150)
	private String complemento;
	
	@Column(name="CIUDAD", length=150)
	private String ciudad;
	
	@Column(name="DP", length=150)
	private String dp;
	
	@Column(name="CODIGO_POSTAL")
	private String codPostal;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE", nullable=false)
	private Cliente cliente;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Direccion other = (Direccion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
