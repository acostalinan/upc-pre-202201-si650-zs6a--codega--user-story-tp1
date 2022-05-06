package pe.edu.upc.trabajoparcial.business.crud.impl;

import java.util.List;



import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.trabajoparcial.business.crud.ClientService;
import pe.edu.upc.trabajoparcial.model.entity.Client;
import pe.edu.upc.trabajoparcial.model.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.model.repository.ClientRepository;

@Named
@ApplicationScoped
public class ClientServiceImpl implements ClientService{

	@Inject
	private ClientRepository ClientRepository;
	
	@Override
	public JpaRepository<Client, Integer> getJpaRepository() {
		return this.ClientRepository;
	}

	@Override
	public List<Client> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return this.ClientRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
