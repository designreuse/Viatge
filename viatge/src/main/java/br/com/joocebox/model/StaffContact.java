package br.com.joocebox.model;

import java.io.Serializable;

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
@Table(name="staff_contact")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class StaffContact implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long tenantId;
	
	private String homePhone;
	
	private String celPhone;
	
	private String workPhone;

	public StaffContact() {

	}

	public StaffContact(String homePhone, String celPhone,
			String workPhone) {
		this.homePhone = homePhone;
		this.celPhone = celPhone;
		this.workPhone = workPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCelPhone() {
		return celPhone;
	}

	public void setCelPhone(String celPhone) {
		this.celPhone = celPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
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
	        final StaffContact other = (StaffContact) obj;
	        return Objects.equal(this.celPhone, other.celPhone)
	            && Objects.equal(this.homePhone, other.homePhone)
	            && Objects.equal(this.workPhone, other.workPhone);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ServiceItem.class)
				.add("Telefone Celular", getCelPhone()).toString();
	}
	
}
