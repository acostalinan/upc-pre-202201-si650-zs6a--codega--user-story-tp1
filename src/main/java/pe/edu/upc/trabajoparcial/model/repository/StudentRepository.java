package pe.edu.upc.trabajoparcial.model.repository;

import java.util.List;


import pe.edu.upc.trabajoparcial.model.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception;
}
