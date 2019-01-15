package sv.gob.cnr.sistemacomercial.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;

@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {	
		if(value != null){
			Long id = null;
			try {

				id = Long.valueOf(value);
				System.out.println("Es de tipo long: " + id);
				CategoriaRepository repository = new CategoriaRepository();
				
				return repository.byId(id);

			} catch (Exception e) {
	
			}
			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		//System.out.println("es de tipo Object: " +  value);
		if(value != null){
			return ((Categoria) value).getId().toString();
		}
		return ""; 
	}


}
