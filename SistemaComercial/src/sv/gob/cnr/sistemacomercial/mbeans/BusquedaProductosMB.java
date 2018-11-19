package sv.gob.cnr.sistemacomercial.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="busquedaProductosMB")
@RequestScoped
public class BusquedaProductosMB {
	private List<Integer> productosFiltrados;

	public BusquedaProductosMB() {
		productosFiltrados = new ArrayList<Integer>();
		for(int i=0; i<50; i++){
			productosFiltrados.add(i);
		}
	}

	public List<Integer> getProductosFiltrados() {
		return productosFiltrados;
	}
	
	
	
	
}
