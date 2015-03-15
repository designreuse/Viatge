package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private Long idCustomer;

	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;

	@Column(name = "birth_date")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "A data de nascimento não pode estar vazia!")
	private Date birthDate;

	@Column(name = "email")
	@NotEmpty(message = "O E-mail não pode estar vazio!")
	private String email;

	@Column(name = "first_name")
	@NotEmpty(message = "O Nome não pode ser vazio!")
	private String firstName;

	@Column(name = "gender")
	private char gender;

	@Column(name = "last_name")
	private String lastName;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_document")
	private Document document;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_customerPhone")
	private CustomerPhone customerPhone;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_customer")
	private Set<Passenger> passenger;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_customerAddress")
	private CustomerAddress customerAddress;

	@Column(name = "observations")
	private String observations;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_customer")
	private Set<CustomerService> customerService;

	public Customer() {
	}

	public Long getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public CustomerPhone getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(CustomerPhone customerPhone) {
		this.customerPhone = customerPhone;
	}

	public CustomerAddress getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(CustomerAddress customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	public Set<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(Set<Passenger> passenger) {
		this.passenger = passenger;
	}

	public Set<CustomerService> getCustomerService() {
		return customerService;
	}

	public void setCustomerService(Set<CustomerService> customerService) {
		this.customerService = customerService;
	}

}