package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PEDIDO")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_SC_PEDIDO_ID")
	@SequenceGenerator(name="SEQ_SC_PEDIDO_ID", sequenceName="SEQ_SC_PEDIDO_ID", allocationSize=1)
	private Long id;
	
	
	@Column(name="FECHA_CREACION", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaCreacion;
	
	@Column(columnDefinition="text")
	private String observaciones;
	
	
	@Column(name="FECHA_ENTREGA")
	@Temporal(TemporalType.DATE)
	private Date fechaEntrega;
	
	@Column(name="VALOR_FLETE", nullable=false, precision=10, scale=2)
	private BigDecimal valorFlete;
	
	@Column(name="VALOR_DESCUENTO", nullable=false, precision=10, scale=2)
	private BigDecimal valorDescuento;
	
	@Column(name="VALOR_TOTAL", nullable=false, precision=10, scale=2)
	private BigDecimal valorTotal;
	
	//Enum
	
	@Enumerated(EnumType.STRING)
	@Column(name="ESTADO_PEDIDO", nullable=false, length=10)
	private EstadoPedido estadoPedido;
	
	@Enumerated(EnumType.STRING)
	@Column(name="FORMA_PAGO", nullable=false, length=10)
	private FormaPago formaPago;
	
	//private Usuario vendedor;
	@ManyToOne
	@JoinColumn(name="ID_CLIENTE", nullable=false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name="ID_DIRECCION_ENTREGA", nullable=false)
	private DireccionEntrega direccionEntrega;
	
	@OneToMany
	@JoinColumn(name="ITEM_PEDIDO_FK")
	private List<ItemPedido> items = new ArrayList<ItemPedido>();
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(Date fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public BigDecimal getValorFlete() {
		return valorFlete;
	}
	public void setValorFlete(BigDecimal valorFlete) {
		this.valorFlete = valorFlete;
	}
	public BigDecimal getValorDescuento() {
		return valorDescuento;
	}
	public void setValorDescuento(BigDecimal valorDescuento) {
		this.valorDescuento = valorDescuento;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public EstadoPedido getEstadoPedido() {
		return estadoPedido;
	}
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido;
	}
	public FormaPago getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(FormaPago formaPago) {
		this.formaPago = formaPago;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public DireccionEntrega getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(DireccionEntrega direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public List<ItemPedido> getItems() {
		return items;
	}
	public void setItems(List<ItemPedido> items) {
		this.items = items;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
