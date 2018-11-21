package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(schema="CURSO_JSF04", name="SC_CONTADOR")
@NamedQuery(name="Contador.findAll", query="SELECT c FROM Contador c")
public class Contador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CNT_ID")
	private Integer cntId;
	
	@Column(name="CNT_NOMBRE")
	private String cntNombre;
	
	@Column(name="CNT_VALOR")
	private Integer cntValor;
	
	@Column(name="CNT_DESCRIPCION")
	private String cntDescripcion;
	
	
	public Integer getCntId() {
		return cntId;
	}
	public void setCntId(Integer cntId) {
		this.cntId = cntId;
	}
	public String getCntNombre() {
		return cntNombre;
	}
	public void setCntNombre(String cntNombre) {
		this.cntNombre = cntNombre;
	}
	public Integer getCntValor() {
		return cntValor;
	}
	public void setCntValor(Integer cntValor) {
		this.cntValor = cntValor;
	}
	public String getCntDescripcion() {
		return cntDescripcion;
	}
	public void setCntDescripcion(String cntDescripcion) {
		this.cntDescripcion = cntDescripcion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cntId == null) ? 0 : cntId.hashCode());
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
		Contador other = (Contador) obj;
		if (cntId == null) {
			if (other.cntId != null)
				return false;
		} else if (!cntId.equals(other.cntId))
			return false;
		return true;
	}

}
