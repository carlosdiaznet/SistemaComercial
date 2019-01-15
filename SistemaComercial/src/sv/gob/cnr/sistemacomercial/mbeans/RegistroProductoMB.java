package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
//import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sv.gob.cnr.sistemacomercial.entities.Producto;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	
	
	
	
	@PostConstruct
	public void init(){
		this.producto = new Producto();
		
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public void guardar() throws Exception{
		try {

			System.out.println("guardado");
			System.out.println("SKU: " + producto.getSku());
			System.out.println("Nombre: " + producto.getNombre());
			System.out.println("Valor unitario: " + producto.getValorUnitario());
			System.out.println("Inventario: " + producto.getInventario());
			System.out.println("Categoria: " + producto.getCategoria().getNombre());
		} catch (Exception e) {

		}
		
	} 
	
	
	/*
	@Inject
	private CategoriaRepository caterorias;
	
	private Producto producto;
	private Categoria categoria;
	
	private List<Categoria> listCategoria;
	
	@PostConstruct
	public void init(){
		producto = new Producto();
		
	}

	public void inicializar(){
		listCategoria = caterorias.listar();
	}
	
	public void guardar() throws Exception{
		try {
			System.out.println("guardado");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Categoria> getListCategoria() {
		return listCategoria;
	}
	
	@NotNull
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	*/
	
}
