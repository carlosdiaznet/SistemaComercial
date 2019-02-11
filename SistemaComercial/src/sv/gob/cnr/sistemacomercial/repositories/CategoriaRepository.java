package sv.gob.cnr.sistemacomercial.repositories;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import sv.gob.cnr.sistemacomercial.entities.Categoria;

public class CategoriaRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public List<Categoria> listar(){
		return manager.createQuery("select c from Categoria c where c.categoriaPadre IS NULL", Categoria.class).getResultList();
	}
	
	public List<Categoria> subCategorias(Categoria categoriaP){
		return manager.createQuery("select c from Categoria c where c.categoriaPadre = :raiz",
				Categoria.class).setParameter("raiz", categoriaP.getId()).getResultList(); //pasamos id como parametro
	}
	
	//Metodo para buscar por id dentro de la lista Resullist
	public Categoria byId(Long id){
		return manager.find(Categoria.class, id);
	}

}
