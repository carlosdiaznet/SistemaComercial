package sv.gob.cnr.sistemacomercial.converter;



import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sv.gob.cnr.sistemacomercial.entities.Categoria;
import sv.gob.cnr.sistemacomercial.mbeans.RegistroProductoMB;



@FacesConverter("categoriaConverter")
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		ValueExpression vex = context.getApplication()
				.getExpressionFactory()
					.createValueExpression(context.getELContext(), "#{registroProductoMB}", RegistroProductoMB.class);
		RegistroProductoMB categorias = (RegistroProductoMB) vex.getValue(context.getELContext());
		
		return categorias.getCategoria(Long.valueOf(value));	
	}
	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null){
			return null;
		}
		return ((Categoria)value).getId().toString();
	
	}
}
