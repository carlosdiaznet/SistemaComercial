package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sv.gob.cnr.sistemacomercial.entities.DireccionEntrega;
import sv.gob.cnr.sistemacomercial.entities.Pedido;

@ManagedBean(name="registroPedidoMB")
@ViewScoped
public class RegistroPedidoMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Pedido pedido;
	private List<Integer> items;

	public RegistroPedidoMB() {
		pedido = new Pedido();
		pedido.setDireccionEntrega(new DireccionEntrega());
		items = new ArrayList<Integer>();
		items.add(1);
	}
	
	public void guardar(){
		
	}

	public List<Integer> getItems() {
		return items;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
	
}
