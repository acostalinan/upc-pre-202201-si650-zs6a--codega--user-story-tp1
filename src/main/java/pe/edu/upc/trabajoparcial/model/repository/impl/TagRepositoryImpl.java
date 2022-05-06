package pe.edu.upc.trabajoparcial.model.repository.impl;

import java.util.List;


import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.trabajoparcial.model.entity.Tag;
import pe.edu.upc.trabajoparcial.model.repository.TagRepository;

@Named
@ApplicationScoped
public class TagRepositoryImpl implements TagRepository {

	@PersistenceContext(unitName = "universityPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Tag> findById(String id) throws Exception {
		return this.findById(id, Tag.class);
	}

	@Override
	public List<Tag> findAll() throws Exception {
		String jpql = "SELECT tag FROM Tag tag";
		return this.findByQuery(Tag.class, jpql);
	}

	@Override
	public List<Tag> findByData(String data) throws Exception {
		String jpql = "SELECT tag FROM Tag tag WHERE Tag.name LIKE '" + data  + "'";
		return this.findByQuery(Tag.class, jpql);
	}

}
