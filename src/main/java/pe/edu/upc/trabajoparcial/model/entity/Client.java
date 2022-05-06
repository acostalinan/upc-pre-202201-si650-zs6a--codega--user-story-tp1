package pe.edu.upc.trabajoparcial.model.entity;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clients", 
	indexes = {@Index(columnList = "last_name, first_name, cellphone, direction, password", name = "clients_index_last_name_first_name_cellphone_direction_password")})
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "last_name", length = 35, nullable = false)
	private String lastName;
	
	@Column(name = "first_name", length = 35, nullable = false)	
	private String firstName;
	
	@Column(name = "cellphone", length = 10, nullable = false)	
	private String cellphone;
	
	@Column(name = "direction", length = 100, nullable = false)	
	private String direction;
	
	@Column(name = "password", length = 50, nullable = false)	
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "tag_id")
	private Tag tag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}
	
}	
