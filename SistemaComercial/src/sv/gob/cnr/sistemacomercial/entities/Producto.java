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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="SC_PRODUCTO")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_PRODUCTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SC_PRODUCTO_ID")
	@SequenceGenerator(name="SEQ_SC_PRODUCTO_ID", sequenceName="SEQ_SC_PRODUCTO_ID", allocationSize=1)
	private Long id;
	
	@Column(name="SKU")
	private String sku;
	
	@Column(name="NOMBRE")
	private String nombre;
	
	@Column(name="VALOR_UNITARIO", nullable=false, precision=10, scale=2)
	private BigDecimal valorUnitario;
	
	@Column(name="INVENTARIO")
	private Integer inventario;
	
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
