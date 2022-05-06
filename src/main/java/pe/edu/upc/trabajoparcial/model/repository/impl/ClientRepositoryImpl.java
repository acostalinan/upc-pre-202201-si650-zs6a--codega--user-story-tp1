package pe.edu.upc.trabajoparcial.model.repository.impl;

import java.util.List;


import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pe.edu.upc.trabajoparcial.model.entity.Client;
import pe.edu.upc.trabajoparcial.model.repository.ClientRepository;

@Named 
@ApplicationScoped
public class ClientRepositoryImpl implements ClientRepository {

	@PersistenceContext(unitName = "trabajoparcialPU")
	private EntityManager entityManager;
	
	@Override
	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	@Override
	public Optional<Client> findById(Integer id) throws Exception {
		return this.findById(id, Client.class);
	}

	@Override
	public List<Client> findAll() throws Exception {
		String jpql = "SELECT student FROM Student student";
		return this.findByQuery(Client.class, jpql);
	}

	@Override
	public List<Client> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		String jpql = "SELECT student FROM Student student WHERE student.lastName = '" + lastName + "' and student.firstName = '" + firstName + "'";
		return this.findByQuery(Client.class, jpql);
	}

	@Override
	public List<Client> findByData(String data) throws Exception {
		String jpql = "SELECT student FROM Student student WHERE student.lastName LIKE '%" + data + "%'";
		return this.findByQuery(Client.class, jpql);
	}

}
