package pe.edu.upc.trabajoparcial.business.crud;

import java.util.List;



import pe.edu.upc.trabajoparcial.model.entity.Client;

public interface ClientService extends CrudService<Client, Integer> {
	List<Client> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
