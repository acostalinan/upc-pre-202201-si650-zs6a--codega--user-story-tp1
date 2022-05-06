package pe.edu.upc.trabajoparcial.business.crud.impl;

import java.util.List;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.trabajoparcial.business.crud.TagService;
import pe.edu.upc.trabajoparcial.model.entity.Tag;
import pe.edu.upc.trabajoparcial.model.repository.TagRepository;
import pe.edu.upc.trabajoparcial.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class TagServiceImpl implements TagService {

	@Inject
	private TagRepository TagRepository;
	
	@Override
	public JpaRepository<Tag, String> getJpaRepository() {
		return this.TagRepository;
	}

}
