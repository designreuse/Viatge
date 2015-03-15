package br.com.joocebox.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "service_item")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class ServiceItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_service_item")
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "fk_service_item_destination")
    private Destination destination;

    @ManyToOne
    @JoinColumn(name = "fk_service_item_customer_service")
    private CustomerService customerService;
    
	@Column(name = "tenant_id", insertable = false, updatable = false)
	private Long tenantId;
	
    @Column(name="value_negotiated")
    private double valueNegotiated;
    
    @Enumerated(EnumType.STRING)
    @Column(name="sale_type")
    private SaleType saleType;
    
    @Column(name="departure_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    
    @Column(name="arrival_date")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date arrivalDate;
    
    @Column(name="requested_destination")
    private Boolean requestedDestination;
    
    @Column(name="negociation_observations")
    private String negociationObservations;

	public ServiceItem() {
		
	}

	public ServiceItem(Destination destination,
			CustomerService customerService, double valueNegotiated,
			SaleType saleType, Date departureDate, Date arrivalDate,
			Boolean requestedDestination, String negociationObservations) {
		this.destination = destination;
		this.customerService = customerService;
		this.valueNegotiated = valueNegotiated;
		this.saleType = saleType;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.requestedDestination = requestedDestination;
		this.negociationObservations = negociationObservations;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public double getValueNegotiated() {
		return valueNegotiated;
	}

	public void setValueNegotiated(double valueNegotiated) {
		this.valueNegotiated = valueNegotiated;
	}

	public SaleType getSaleType() {
		return saleType;
	}

	public void setSaleType(SaleType saleType) {
		this.saleType = saleType;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Boolean getRequestedDestination() {
		return requestedDestination;
	}

	public void setRequestedDestination(Boolean requestedDestination) {
		this.requestedDestination = requestedDestination;
	}

	public String getNegociationObservations() {
		return negociationObservations;
	}

	public void setNegociationObservations(String negociationObservations) {
		this.negociationObservations = negociationObservations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result
				+ ((customerService == null) ? 0 : customerService.hashCode());
		result = prime * result
				+ ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result
				+ ((destination == null) ? 0 : destination.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((negociationObservations == null) ? 0
						: negociationObservations.hashCode());
		result = prime
				* result
				+ ((requestedDestination == null) ? 0 : requestedDestination
						.hashCode());
		result = prime * result
				+ ((saleType == null) ? 0 : saleType.hashCode());
		result = prime * result
				+ ((tenantId == null) ? 0 : tenantId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valueNegotiated);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ServiceItem))
			return false;
		ServiceItem other = (ServiceItem) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (customerService == null) {
			if (other.customerService != null)
				return false;
		} else if (!customerService.equals(other.customerService))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (destination == null) {
			if (other.destination != null)
				return false;
		} else if (!destination.equals(other.destination))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (negociationObservations == null) {
			if (other.negociationObservations != null)
				return false;
		} else if (!negociationObservations
				.equals(other.negociationObservations))
			return false;
		if (requestedDestination == null) {
			if (other.requestedDestination != null)
				return false;
		} else if (!requestedDestination.equals(other.requestedDestination))
			return false;
		if (saleType != other.saleType)
			return false;
		if (tenantId == null) {
			if (other.tenantId != null)
				return false;
		} else if (!tenantId.equals(other.tenantId))
			return false;
		if (Double.doubleToLongBits(valueNegotiated) != Double
				.doubleToLongBits(other.valueNegotiated))
			return false;
		return true;
	}



}