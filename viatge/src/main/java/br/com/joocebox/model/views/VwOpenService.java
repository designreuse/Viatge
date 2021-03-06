package br.com.joocebox.model.views;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.ReadOnly;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;

import com.google.common.base.Objects;
import com.google.common.hash.Hashing;


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
	
	@Id
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
	
	@Column(name="value_negotiated")
	private Double price;
	
	@Column(name="sale_type")
	private String saleType;
	
	@Column(name ="site")
	private Boolean site;


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

	public Boolean getSite() {
		return site;
	}


	public void setSite(Boolean site) {
		this.site = site;
	}


	@Override
	public int hashCode() {
		return Hashing.sha1().hashCode();
	}


	@Override
	public boolean equals(Object obj) {
	       if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        final VwOpenService other = (VwOpenService) obj;
	        return Objects.equal(this.price, other.price)
	            && Objects.equal(this.firstName, other.firstName)
	            && Objects.equal(this.saleType, other.saleType)
	            && Objects.equal(this.seeIn, other.seeIn);
	}


	@Override
	public String toString() {
		return "VwOpenService [id=" + id + ", tenantId=" + tenantId
				+ ", idCustomerService=" + idCustomerService
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateService=" + dateService + ", price=" + price
				+ ", saleType=" + saleType + "]";
	}



}