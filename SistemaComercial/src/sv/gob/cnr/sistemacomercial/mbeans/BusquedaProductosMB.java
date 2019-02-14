package sv.gob.cnr.sistemacomercial.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.repositories.ProductoRepository;

@ManagedBean(name="busquedaProductosMB")
@RequestScoped
public class BusquedaProductosMB {
	
	private List<Producto> productosFiltrados;
	
	@Inject
	private ProductoRepository productos;

	public void init() {
		this.productosFiltrados = new ArrayList<Producto>();
	}
	
	public void inicializar() throws Exception {
		try {
			productosFiltrados = productos.listarProductos();
		} catch (Exception e) {
			throw e;
		}
		
	}

	public List<Producto> getProductosFiltrados() {
		return productosFiltrados;
	}
	
	
	
	
}
