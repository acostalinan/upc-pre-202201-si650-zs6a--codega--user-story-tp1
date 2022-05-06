package pe.edu.upc.trabajoparcial.model.repository;

import java.util.List;



import pe.edu.upc.trabajoparcial.model.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
	List<Client> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
