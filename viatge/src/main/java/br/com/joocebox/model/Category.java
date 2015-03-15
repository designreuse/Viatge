package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private Long idCategory;

	@Column(name="ct_active")
	private int ctActive;

	@Column(name="ct_name")
	@NotEmpty
	@Size(min=3, max=25)
	private String ctName;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@OneToMany(mappedBy="categories", fetch=FetchType.EAGER)
	private Set<Destination> destination;

	public Category() {
	}

	public Long getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public int getCtActive() {
		return this.ctActive;
	}

	public void setCtActive(int ctActive) {
		this.ctActive = ctActive;
	}

	public String getCtName() {
		return this.ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	
	public Set<Destination> getDestination() {
		return destination;
	}

	public void setDestination(Set<Destination> destination) {
		this.destination = destination;
	}
	
	public int getDestinationSize(){
		return destination.size();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ctActive;
		result = prime * result + ((ctName == null) ? 0 : ctName.hashCode());
		result = prime * result
				+ ((idCategory == null) ? 0 : idCategory.hashCode());
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
		Category other = (Category) obj;
		if (ctActive != other.ctActive)
			return false;
		if (ctName == null) {
			if (other.ctName != null)
				return false;
		} else if (!ctName.equals(other.ctName))
			return false;
		if (idCategory == null) {
			if (other.idCategory != null)
				return false;
		} else if (!idCategory.equals(other.idCategory))
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
		return "Category [idCategory=" + idCategory + ", ctActive=" + ctActive
				+ ", ctName=" + ctName + ", tenantId=" + tenantId + "]";
	}
	
	

}