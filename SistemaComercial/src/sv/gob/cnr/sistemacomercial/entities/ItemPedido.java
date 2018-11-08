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
@Table(name="SC_ITEM_PEDIDO")
public class ItemPedido implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID_ITEM_PEDIDO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_ITEM_PEDIDO_ID")
	@SequenceGenerator(name="SEQ_ITEM_PEDIDO_ID", sequenceName="SEQ_ITEM_PEDIDO_ID", allocationSize=1)
	private Long id;
	
	@Column(name="CANTIDAD", nullable=false, length=3)
	private Integer cantidad;
	
	@Column(name="VALOR_UNITARIO", nullable=false, precision=10, scale=2)
	private BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumn(name="ID_PRODUCTO",nullable=false)
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name="ID_PEDIDO",nullable=false)
	private Pedido pedido;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
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
		ItemPedido other = (ItemPedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

	
	

}
