package pe.edu.upc.trabajoparcial.controller;

import javax.annotation.PostConstruct;


import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.trabajoparcial.business.crud.CrudService;
import pe.edu.upc.trabajoparcial.business.crud.ClientService;
import pe.edu.upc.trabajoparcial.model.entity.Tag;
import pe.edu.upc.trabajoparcial.model.entity.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("ClientView")
@ViewScoped
public class ClientView implements Serializable, EntityView<Client, Integer> {

	private static final long serialVersionUID = 1L;
	
	private List<Client> entities;
	private Client entitySelected;
	private List<Client> entitiesSelected;
	private Client entitySearch;
	
	@Inject
	private ClientService entityService;
	
	@PostConstruct
	public void init() {
		this.entitiesSelected = new ArrayList<>();
		this.entitySearch = new Client();
		getAllEntities();
	}
	
	@Override
	public CrudService<Client, Integer> getCrudService() {
		return this.entityService;
	}

	@Override
	public void createNew() {
		this.entitySelected = new Client();		
		this.entitySelected.setTag(new Tag());
	}

	@Override
	public Integer getIdFromEntitySelected() {
		return this.entitySelected.getId();
	}

	public void searchEntity() {
		try {	
			this.entities = this.entityService.search(this.entitySearch.getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	public List<Client> getEntities() {
		return entities;
	}

	public void setEntities(List<Client> entities) {
		this.entities = entities;
	}

	public Client getEntitySelected() {
		return entitySelected;
	}

	public void setEntitySelected(Client entitySelected) {
		this.entitySelected = entitySelected;
	}

	public List<Client> getEntitiesSelected() {
		return entitiesSelected;
	}

	public void setEntitiesSelected(List<Client> entitiesSelected) {
		this.entitiesSelected = entitiesSelected;
	}

	public Client getEntitySearch() {
		return entitySearch;
	}

	public void setEntitySearch(Client entitySearch) {
		this.entitySearch = entitySearch;
	}

	public ClientService getEntityService() {
		return entityService;
	}

	public void setEntityService(ClientService entityService) {
		this.entityService = entityService;
	}
	
		
	
}
