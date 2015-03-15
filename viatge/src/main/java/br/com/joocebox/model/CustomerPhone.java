package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;


/**
 * The persistent class for the customer_phone database table.
 * 
 */
@Entity
@Table(name="customer_phone")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class CustomerPhone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_phone")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;

	@Column(name="cel_phone")
	private String celPhone;

	@Column(name="home_phone")
	private String homePhone;

	@Column(name="work_phone")
	private String workPhone;


	public CustomerPhone() {
	}


	public Long getId() {
		return id;
	}


	public String getCelPhone() {
		return celPhone;
	}


	public String getHomePhone() {
		return homePhone;
	}


	public String getWorkPhone() {
		return workPhone;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}


	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}


	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}


	public Long getTenantId() {
		return tenantId;
	}


	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

}