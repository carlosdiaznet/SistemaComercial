package sv.gob.cnr.sistemacomercial.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sv.gob.cnr.sistemacomercial.cdi.CDIServiceLocator;
import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

@FacesConverter(value = "categoryConverter", forClass = Categoria.class)
public class CategoryConverter implements Converter {
	
	private CategoriaRepository categorias;

	public CategoryConverter() {
		categorias = CDIServiceLocator.getBean(CategoriaRepository.class);
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria retorno = null;
		if(value != null){
			Long id = new Long(value);
			retorno = categorias.byId(id);
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			return ((Categoria) value).getId().toString();
		}
		return "";
	}

}
