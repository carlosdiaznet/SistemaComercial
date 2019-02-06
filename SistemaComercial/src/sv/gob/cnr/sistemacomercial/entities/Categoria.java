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
@Table(schema = "CURSO_JSF04", name="SC_CATEGORIA")
@NamedQuery(name="Categoria.findAll", query="SELECT a FROM Categoria a")
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ID_CATEGORIA", schema="CURSO_JSF04", table="SC_CONTADOR", 
		pkColumnName="CNT_NOMBRE", valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ID_CATEGORIA")
	@Column(name="ID_CATEGORIA")
	private Long id;
	
	@Column(name="NOMBRE", nullable=false, length=50)
	private String nombre;
	
	@Column(name="DESCRIPCION", nullable=true, length=200)
	private String descripcion;
	
	@Column(name="CATEGORIA_PADRE", nullable=true, length=50)
	private Long categoriaPadre;
	
	@OneToMany(mappedBy="categoria", cascade = CascadeType.ALL)
	List<Producto> productos = new ArrayList<Producto>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Long getCategoriaPadre() {
		return categoriaPadre;
	}
	public void setCategoriaPadre(Long categoriaPadre) {
		this.categoriaPadre = categoriaPadre;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
