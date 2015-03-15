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
@Table(name="economic_profile")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class EconomicProfile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_economic")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@Column(name="economic_travel")
	private Boolean economic;
	
	@Column(name="intermediate_travel")
	private Boolean intermediate;
	
	@Column(name="luxury_travel")
	private Boolean luxury;
	
	public EconomicProfile(){
		
	}

	public Long getId() {
		return id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public Boolean getEconomic() {
		return economic;
	}

	public Boolean getIntermediate() {
		return intermediate;
	}

	public Boolean getLuxury() {
		return luxury;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public void setEconomic(Boolean economic) {
		this.economic = economic;
	}

	public void setIntermediate(Boolean intermediate) {
		this.intermediate = intermediate;
	}

	public void setLuxury(Boolean luxury) {
		this.luxury = luxury;
	}
}