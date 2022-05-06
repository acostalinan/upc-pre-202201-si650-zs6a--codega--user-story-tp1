package pe.edu.upc.trabajoparcial.model.entity;

import java.util.ArrayList;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tag", indexes = {@Index(columnList = "name, type, description", name = "tag_index_type_description")})
public class Tag {
	@Id
	@Column(name = "id", length = 3)
	private String id;
	
	@Column(name = "type", length = 100, nullable = false)
	private String type;
	
	@Column(name = "description", length = 100, nullable = false)
	private String description;
	
	@OneToMany(mappedBy = "tag")
	private List<Client> clients;
	
	public Tag() {
		clients = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
}

