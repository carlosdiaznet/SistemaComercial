package sv.gob.cnr.sistemacomercial.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.mbeans.CategoriaMB;
import sv.gob.cnr.sistemacomercial.repositories.CategoriaRepository;


@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	CategoriaRepository mbean;
	
	

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		long id = 0;
		Categoria registro;
		id = Long.parseLong(value);
		CategoriaMB categoriaId = new CategoriaMB();
		registro = categoriaId.objCategoria(id);
		  
		return registro;	
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		try {
			if(value != null && value.getClass().equals(Categoria.class)){
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
