package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.filter.ProductoFilter;
import sv.gob.cnr.sistemacomercial.repositories.ProductoRepository;

@ManagedBean(name="busquedaProductosMB")
@RequestScoped
public class BusquedaProductosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Producto> productosFiltrados;
	
	private List<Producto> filteredProducts;
	
	@Inject
	private ProductoRepository productos;
	
	private ProductoFilter filtro;

	@PostConstruct
	public void init() {
		this.productosFiltrados = new ArrayList<Producto>();
		this.filtro = new ProductoFilter();
		productosFiltrados = productos.listarProductos();
		System.out.println(filtro);
	}
	
	public void buscarProductos(){
			productosFiltrados = productos.filtrados(filtro);
	}
	
	public List<Producto> getProductosFiltrados() {
		return productosFiltrados;
	}

	public List<Producto> getFilteredProducts() {
		return filteredProducts;
	}

	public void setFilteredProducts(List<Producto> filteredProducts) {
		this.filteredProducts = filteredProducts;
	}

	public ProductoFilter getFiltro() {
		return filtro;
	}
	
	
	
	
}
