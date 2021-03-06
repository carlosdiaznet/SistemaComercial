package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(schema = "CURSO_JSF04", name="SC_GRUPO")
@NamedQuery(name="Grupo.findAll", query="SELECT a FROM Grupo a")
public class Grupo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ID_GRUPO", schema="CURSO_JSF04", table="SC_CONTADOR", 
		pkColumnName="CNT_NOMBRE", valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ID_GRUPO")
	@Column(name="ID_GRUPO")
	private Long id;
	
	@Column(name="ROL", nullable=false, length=100)
	private String rol;
	
	@OneToMany(mappedBy="grupo", cascade = CascadeType.ALL)
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
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
		Grupo other = (Grupo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
