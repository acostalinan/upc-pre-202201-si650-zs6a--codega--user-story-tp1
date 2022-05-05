package pe.edu.upc.trabajoparcial.business.crud.impl;

import java.util.List;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.trabajoparcial.business.crud.CareerService;
import pe.edu.upc.trabajoparcial.model.entity.Career;
import pe.edu.upc.trabajoparcial.model.repository.CareerRepository;
import pe.edu.upc.trabajoparcial.model.repository.JpaRepository;

@Named
@ApplicationScoped
public class CareerServiceImpl implements CareerService {

	@Inject
	private CareerRepository careerRepository;
	
	@Override
	public JpaRepository<Career, String> getJpaRepository() {
		return this.careerRepository;
	}

}
