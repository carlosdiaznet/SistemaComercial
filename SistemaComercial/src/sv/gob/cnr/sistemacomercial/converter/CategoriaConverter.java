package sv.gob.cnr.sistemacomercial.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

//import sv.gob.cnr.sistemacomercial.cdi.CDIServiceLocator;
import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

//@FacesConverter(value="categoriaConverter", forClass= Categoria.class)
@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Categoria objCategoria = null;
		if(value != null){
			Long id = null;
			try {
				System.out.println("es de tipo String: " + value);
				id = Long.valueOf(value);
			} catch (NumberFormatException e) {
				// TODO: handle exception
			}
			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		// TODO Auto-generated method stub
		return null;
	}
	
/*	
	//@Inject
	private CategoriaRepository categorias = new CategoriaRepository();
	
	

	public CategoriaConverter() {
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
	
	*/

}
