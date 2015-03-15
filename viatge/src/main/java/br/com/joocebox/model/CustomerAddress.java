package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;

@Entity
@Table(name="customer_address")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class CustomerAddress implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_address")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;

	@Column(name="cep")
	private String cep;

	@Column(name="complement")
	private String complement;

	@Column(name="number")
	private String number;

	@Column(name="quarter")
	private String quarter;

	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;

	@Column(name="state")
	private String state;
	
	
	@OneToOne
	@JoinColumn(name="fk_country")
	private Country country;


//	@OneToOne
//	@JoinColumn(name="fk_state")
//	private State state;

	public CustomerAddress() {
	}

	public Long getId() {
		return id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public String getCep() {
		return cep;
	}

	public String getComplement() {
		return complement;
	}

	public String getNumber() {
		return number;
	}

	public String getQuarter() {
		return quarter;
	}

	public String getStreet() {
		return street;
	}

	public Country getCountry() {
		return country;
	}
	
//	public void setState(State state) {
//		this.state = state;
//	}
//
//	public State getState() {
//		return state;
//	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}
}