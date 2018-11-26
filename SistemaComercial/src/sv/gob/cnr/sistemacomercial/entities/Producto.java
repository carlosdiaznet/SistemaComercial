package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(schema = "CURSO_JSF04", name="SC_PRODUCTO")
@NamedQuery(name="Producto.findAll", query="SELECT a FROM Producto a")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@TableGenerator(name="ID_PRODUCTO", schema="CURSO_JSF04", table="SC_CONTADOR", 
		pkColumnName="CNT_NOMBRE", valueColumnName="CNT_VALOR", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ID_PRODUCTO")
	@Column(name="ID_PRODUCTO")
	private Long id;
	
	@NotNull
	@Column(name="SKU", nullable=false, length=20, unique=true)
	private String sku;
	
	@NotNull
	@Size(max=80)
	@Column(name="NOMBRE", nullable=false, length=80)
	private String nombre;
	
	@NotNull
	@Column(name="VALOR_UNITARIO", nullable=false, precision=10, scale=2)
	private BigDecimal valorUnitario;
	
	@NotNull @Min(0) @Max(9999)
	@Column(name="INVENTARIO")
	private Integer inventario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA", nullable=false)
	private Categoria categoria;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	public Integer getInventario() {
		return inventario;
	}
	public void setInventario(Integer inventario) {
		this.inventario = inventario;
	}
	
	
	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
