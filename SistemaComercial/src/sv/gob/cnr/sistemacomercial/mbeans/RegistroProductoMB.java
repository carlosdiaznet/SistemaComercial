package sv.gob.cnr.sistemacomercial.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import sv.gob.cnr.sistemacomercial.controller.ProductoController;
import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;
import sv.gob.cnr.sistemacomercial.repositories.ProductoRepository;

@ManagedBean(name = "registroProductoMB")
@ViewScoped
public class RegistroProductoMB implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Producto producto;
	private Categoria categoria;
	
	@Inject
	private CategoriaRepository caterorias;
	
	@Inject
	private ProductoRepository productos;
	
	private List<Categoria> listCategoria;
	private List<Categoria> subCategoria;
		
	@PostConstruct
	public void init(){
		this.producto = new Producto();	
	}
	
	public void inicializar(String valor) throws Exception{
		try {
			if(valor.equals("F")){
				if(isPostback() == false){ listCategoria = caterorias.listar(); }
			} else {
				listCategoria = caterorias.listar();
			}
		} catch (Exception e) {
			throw e;
		}	
	}
	
	private boolean isPostback(){
		return FacesContext.getCurrentInstance().isPostback();
	}
	
	public void guardar() throws Exception{
		ProductoController reg;
		
		try {
			if(productos.porSku(producto.getSku()) == null){
				reg = new ProductoController();
				reg.registrarProducto(producto);
				limpiar();
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro Completado"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "SKU ya existe en la DB"));
			}
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
			throw e;
		}
	}
	
	public void editar() throws Exception{
		ProductoController reg;
		try {
			reg = new ProductoController();
			reg.actualizarProducto(producto);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Registro actualizado"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
		}
	}
	
	private void limpiar(){
		producto = new Producto();
		categoria = null;
		subCategoria = new ArrayList<Categoria>();
	}
	
	public void loadSubcategorias(){
		subCategoria = caterorias.subCategorias(categoria);
	}
	
	public void productoID(Producto prd) throws Exception{
		ProductoController var;
		try {
			var = new ProductoController();
			producto = var.productoID(prd);
			this.categoria = producto.getCategoria();
		} catch (Exception e) {
			throw e;
		}
	}
	
	/*METODOS GET Y SET*/

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
		/*if(this.producto != null){
			this.categoria = this.producto.getCategoria();
		}*/
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public List<Categoria> getListCategoria() {
		return listCategoria;
	}

	public List<Categoria> getSubCategoria() {
		return subCategoria;
	}
}
