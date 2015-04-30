package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name = "professional_data")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class ProfessionalData implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;
	
	@Column(name="job_title")
	@NotEmpty(message="Informe a função do colaborador.")
	@NotNull
	private String jobTitle;
	
	@Valid
	@Enumerated(EnumType.STRING)
	@Column(name="role")
	private Role role;
	
	public ProfessionalData(){
		
	}
	
	public ProfessionalData(Long id, Long tenantId, String jobTitle, Role role) {
		this.jobTitle = jobTitle;
		this.role = role;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public Long getTenantId() {
		return tenantId;
	}
	
	@Override
	public int hashCode() {
		return Hashing.sha1().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	       if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        final ProfessionalData other = (ProfessionalData) obj;
	        return Objects.equal(this.jobTitle, other.jobTitle)
	            && Objects.equal(this.role, other.role);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ServiceItem.class)
				.add("Dados Profissionais, Função", getJobTitle())
				.add("Regra de Acesso", getRole()).toString();
	}
	

}
