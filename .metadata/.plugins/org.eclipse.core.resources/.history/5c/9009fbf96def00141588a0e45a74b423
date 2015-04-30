package br.com.joocebox.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_address")
	private int idAddress;

	private String cep;

	private String complement;

	private String number;

	private String quarter;

	private String street;

	//bi-directional many-to-one association to Template
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fk_template")
	private Template template;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="address")
	private Set<Contact> contacts;

//	//bi-directional many-to-one association to State
//	@OneToMany(mappedBy="address")
//	private Set<State> states;

	public Address() {
	}

	public int getIdAddress() {
		return this.idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplement() {
		return this.complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getQuarter() {
		return this.quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Template getTemplate() {
		return this.template;
	}

	public void setTemplate(Template template) {
		this.template = template;
	}

	public Set<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setAddress(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setAddress(null);

		return contact;
	}

//	public Set<State> getStates() {
//		return this.states;
//	}
//
//	public void setStates(Set<State> states) {
//		this.states = states;
//	}

}