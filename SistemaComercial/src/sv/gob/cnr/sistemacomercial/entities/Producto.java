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

import org.hibernate.validator.constraints.NotBlank;

import sv.gob.cnr.sistemacomercial.validation.SKU;

//import sv.gob.cnr.sistemacomercial.validation.SKU;

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
	
	
	@SKU
	@NotBlank
	@Column(name="SKU", nullable=false, length=20, unique=true)
	private String sku;
	
	@NotBlank
	@Size(max=80)
	@Column(name="NOMBRE", nullable=false, length=80)
	private String nombre;
	
	@NotNull(message = "es necesario...")
	@Column(name="VALOR_UNITARIO", nullable=false, precision=10, scale=2)
	private BigDecimal valorUnitario;
	
	@NotNull(message = "es obligatorio...")
	@Min(value = 0, message = "no puede ser negativo") @Max(value=9999, message = "es un valor muy alto")
	@Column(name="INVENTARIO")
	private Integer inventario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIA", nullable=false)
	private Categoria categoria;
	
	public Producto() {
		
	}

	public Producto(Long id, String sku, String nombre, BigDecimal valorUnitario, Integer inventario,
			Categoria categoria) {
		super();
		this.id = id;
		this.sku = sku;
		this.nombre = nombre;
		this.valorUnitario = valorUnitario;
		this.inventario = inventario;
		this.categoria = categoria;
		setCategoria(categoria);
	}
		
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
