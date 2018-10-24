package sv.gob.cnr.sistemacomercial.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Date fechaCreacion;
	private String observaciones;
	private Date fechaEntrega;
	private BigDecimal valorFlete;
	private BigDecimal valorDescuento;
	private BigDecimal valorTotal;
	
	//Enum
	private EstadoPedido estadoPedido;
	private FormaPago formaPago;
	
	//private Usuario vendedor;
	private Cliente cliente;
	private DireccionEntrega direccionEntrega;
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
