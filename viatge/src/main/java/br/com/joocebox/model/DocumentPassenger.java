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

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name="document_passenger")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class DocumentPassenger implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_document")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@Column(name="rg_number")
	private String rg;
	
	@Column(name="cpf_number")
	private String cpf;
	
	public DocumentPassenger() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@Override
	public int hashCode() {
		return Hashing.sha1().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	       if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        final DocumentPassenger other = (DocumentPassenger) obj;
	        return Objects.equal(this.cpf, other.cpf)
	            && Objects.equal(this.rg, other.rg);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(DocumentPassenger.class)
				.add("CPF do Passageiro", getCpf())
				.add("RG do Passageiro", getRg()).toString();
	}

}