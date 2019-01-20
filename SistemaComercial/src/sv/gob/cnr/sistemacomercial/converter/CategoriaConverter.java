package sv.gob.cnr.sistemacomercial.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;


@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	CategoriaRepository mbean;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		try {
			long id = 0;
			Categoria registro;
			if(value.trim().equals("")){
				return null;
			} else {
				try {
					id = Long.parseLong(value);
				} catch (Exception e) {
					return null;
				}
				registro = (Categoria) getMbean().byId(id);
				return registro;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		//System.out.println("es de tipo Object: " +  value);
		try {
			if(value != null && value.getClass().equals(Categoria.class)){
				//return ((Categoria) value).getId().toString();
				return String.valueOf(((Categoria) value).getId());
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	
	}

	public CategoriaRepository getMbean() {
		return mbean;
	}

	public void setMbean(CategoriaRepository mbean) {
		this.mbean = mbean;
	}


}
/**A1
					//System.out.println("Es de tipo long: " + id);
					//CategoriaRepository repository = new CategoriaRepository();
					
					//return repository.byId(id);

*/