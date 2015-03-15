package br.com.joocebox.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer_service")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class CustomerService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer_service")
	private Long id;

	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;

	@Column(name = "date_service")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name = "average_budget")
	private BigDecimal averageBudget;

	@Column(name = "service_situation")
	private boolean situation;

	@OneToMany(mappedBy = "customerService")
	private Set<ServiceItem> serviceItem;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_history")
	private List<History> history;

	@Column(name = "service_observatons")
	private String serviceObservations;

	public CustomerService() {

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isSituation() {
		return situation;
	}

	public void setSituation(boolean situation) {
		this.situation = situation;
	}

	public Set<ServiceItem> getServiceItem() {
		return serviceItem;
	}

	public void setServiceItem(Set<ServiceItem> serviceItemList) {
		this.serviceItem = serviceItemList;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history2) {
		this.history = history2;
	}

	public String getServiceObservations() {
		return serviceObservations;
	}

	public void setServiceObservations(String serviceObservations) {
		this.serviceObservations = serviceObservations;
	}

	public BigDecimal getAverageBudget() {
		return averageBudget;
	}

	public void setAverageBudget(BigDecimal averageBudget) {
		this.averageBudget = averageBudget;
	}

}