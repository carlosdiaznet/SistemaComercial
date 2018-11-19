package sv.gob.cnr.sistemacomercial.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="registroPedidoBean")
@RequestScoped
public class RegistroPedidoBean {
	private List<Integer> items;

	public RegistroPedidoBean() {
		items = new ArrayList<Integer>();
		items.add(1);
	}

	public List<Integer> getItems() {
		return items;
	}
	
}
