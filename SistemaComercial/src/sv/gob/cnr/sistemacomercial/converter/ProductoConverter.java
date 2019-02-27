package sv.gob.cnr.sistemacomercial.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.gob.cnr.sistemacomercial.cdi.CDIServiceLocator;
import sv.gob.cnr.sistemacomercial.entities.Producto;
import sv.gob.cnr.sistemacomercial.repositories.ProductoRepository;

@FacesConverter(value = "productoConverter", forClass = Producto.class)
public class ProductoConverter implements Converter {
	
	private ProductoRepository productos;

	public ProductoConverter() {
		productos = CDIServiceLocator.getBean(ProductoRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Producto retorno = null;
		if(value != null){
			Long id = new Long(value);
			retorno = productos.byId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Producto) value).getId().toString();
		}
		return "";
	}

}
