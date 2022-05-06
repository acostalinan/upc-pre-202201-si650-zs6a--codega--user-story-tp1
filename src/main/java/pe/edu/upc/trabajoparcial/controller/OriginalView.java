package pe.edu.upc.trabajoparcial.controller;

import javax.annotation.PostConstruct;


import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import pe.edu.upc.trabajoparcial.business.crud.ClientService;
import pe.edu.upc.trabajoparcial.model.entity.Tag;
import pe.edu.upc.trabajoparcial.model.entity.Client;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("originalView")
@ViewScoped
public class OriginalView implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Client> entities;
	private Client entitySelected;
	private List<Client> entitiesSelected;
	private Client entitySearch;
	
	@Inject
	private ClientService entityService;
	
	@PostConstruct
	public void init() {
		entitiesSelected = new ArrayList<>();
		entitySearch = new Client();
		getAllEntities();
	}
	
	public boolean hasEntitiesSelected() {
		if (entitiesSelected.isEmpty()) {
			return false;
		}
		return true;
	}
	public boolean hasEntitySelected() {
		if (entitiesSelected.size() == 1) {
			return true;
		}
		return false;
	}
	public void createNew() {
		entitySelected = new Client();		
		entitySelected.setTag(new Tag()); 
	}
	public void editEntitySelected() {
		entitySelected = entitiesSelected.get(0);
	}
	public void saveEntity() {
		try {
			if (entitySelected.getId() == null) {
				entityService.create(entitySelected);
				entities.add(entitySelected);
			} 
			else {
				entityService.update(entitySelected);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		PrimeFaces.current().executeScript("PF('entityDialog').hide()");
        PrimeFaces.current().ajax().update("entityDataTable");
	}
	public void deleteEntity() {
		try {
			this.entities.remove(entitySelected);
			entityService.deleteById(this.entitySelected.getId());
			this.entitySelected = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Remove", "Item Removed"));
		PrimeFaces.current().ajax().update("form:messages", "entityDataTable");
	}
	public void searchEntity() {
		try {	// MOdificar de acuerdo al Entity
			entities = entityService.search(entitySearch.getLastName());
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	public void getAllEntities() {
		try {
			entities = entityService.getAll();
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
