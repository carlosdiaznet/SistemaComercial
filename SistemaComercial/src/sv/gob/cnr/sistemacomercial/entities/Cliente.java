package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "SC_CLIENTE")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SC_CLIENTE_ID")
	@SequenceGenerator(name="SEQ_SC_CLIENTE_ID", sequenceName="SEQ_SC_CLIENTE_ID", allocationSize=1)
	private long id;
	
	@NotNull
	@Column(name = "NOMBRE", nullable=false, length=100)
	private String nombre;
	
	@Column(name="EMAIL", length=100)
	private String email;
	
	@Column(name="DUI", length=10)
	private String dui;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO", nullable=false, length=10)
	private TipoPersona tipo;
	
	
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Direccion> direcciones = new ArrayList<Direccion>();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDui() {
		return dui;
	}
	public void setDui(String dui) {
		this.dui = dui;
	}
	
	public TipoPersona getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoPersona tipo) {
		this.tipo = tipo;
	}
	
	public List<Direccion> getDirecciones() {
		return direcciones;
	}
	
	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
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
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
}
