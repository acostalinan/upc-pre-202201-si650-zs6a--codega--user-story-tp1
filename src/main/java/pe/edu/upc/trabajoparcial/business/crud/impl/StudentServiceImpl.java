package pe.edu.upc.trabajoparcial.business.crud.impl;

import java.util.List;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.trabajoparcial.business.crud.StudentService;
import pe.edu.upc.trabajoparcial.model.entity.Student;
import pe.edu.upc.trabajoparcial.model.repository.JpaRepository;
import pe.edu.upc.trabajoparcial.model.repository.StudentRepository;

@Named
@ApplicationScoped
public class StudentServiceImpl implements StudentService{

	@Inject
	private StudentRepository studentRepository;
	
	@Override
	public JpaRepository<Student, Integer> getJpaRepository() {
		return this.studentRepository;
	}

	@Override
	public List<Student> findByLastNameAndFirstName(String lastName, String firstName) throws Exception {
		return this.studentRepository.findByLastNameAndFirstName(lastName, firstName);
	}

}
