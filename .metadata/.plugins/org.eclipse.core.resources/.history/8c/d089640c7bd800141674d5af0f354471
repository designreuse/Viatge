package br.com.joocebox.model.views;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;


/**
 * The persistent class for the vw_open_services database table.
 * 
 */

@ReadOnly
@Entity
@Table(name="vw_open_services")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class VwOpenService implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@Column(name="id_customer")
	private Long id;
	
	@Column(name="id_customer_service")
	private Long idCustomerService;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="date_service")
	@Temporal(TemporalType.DATE)
	private Date dateService;
	
	@Column(name="see_in")
	@Temporal(TemporalType.DATE)
	private Date seeIn;
	
	@Id
	@Column(name="value_negotiated")
	private Double price;
	
	@Column(name="sale_type")
	private String saleType;


	public VwOpenService() {
	}
	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public Long getIdCustomerService() {
		return idCustomerService;
	}


	public void setIdCustomerService(Long idCustomerService) {
		this.idCustomerService = idCustomerService;
	}


	public Long getTenantId() {
		return tenantId;
	}



	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public Date getDateService() {
		return dateService;
	}



	public void setDateService(Date dateService) {
		this.dateService = dateService;
	}



	public Date getSeeIn() {
		return seeIn;
	}


	public void setSeeIn(Date seeIn) {
		this.seeIn = seeIn;
	}


	public Double getPrice() {
		return price;
	}



	public void setDouble(Double price) {
		this.price = price;
	}



	public String getSaleType() {
		return saleType;
	}



	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateService == null) ? 0 : dateService.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((idCustomerService == null) ? 0 : idCustomerService
						.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((saleType == null) ? 0 : saleType.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VwOpenService other = (VwOpenService) obj;
		if (dateService == null) {
			if (other.dateService != null)
				return false;
		} else if (!dateService.equals(other.dateService))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idCustomerService == null) {
			if (other.idCustomerService != null)
				return false;
		} else if (!idCustomerService.equals(other.idCustomerService))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (saleType == null) {
			if (other.saleType != null)
				return false;
		} else if (!saleType.equals(other.saleType))
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "VwOpenService [id=" + id + ", tenantId=" + tenantId
				+ "idCustomerService=" + idCustomerService 
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateService=" + dateService + ", price=" + price
				+ ", saleType=" + saleType + "]";
	}



}