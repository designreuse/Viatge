package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;

@Entity
@Table(name="general_profile")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public 	class GeneralProfile implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_general")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	private Boolean beach;
	
	private Boolean cottage;
	
	private Boolean mountain;
	
	private Boolean city;
	
	
	public GeneralProfile(){
		
	}


	public Long getId() {
		return id;
	}


	public Long getTenantId() {
		return tenantId;
	}


	public Boolean getBeach() {
		return beach;
	}


	public Boolean getCottage() {
		return cottage;
	}


	public Boolean getMountain() {
		return mountain;
	}


	public Boolean getCity() {
		return city;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}


	public void setBeach(Boolean beach) {
		this.beach = beach;
	}


	public void setCottage(Boolean cottage) {
		this.cottage = cottage;
	}


	public void setMountain(Boolean mountain) {
		this.mountain = mountain;
	}


	public void setCity(Boolean city) {
		this.city = city;
	}

		

}