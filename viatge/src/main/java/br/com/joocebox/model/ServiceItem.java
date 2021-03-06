package br.com.joocebox.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.hash.Hashing;

@Entity
@Table(name = "service_item")
@Multitenant
@TenantDiscriminatorColumn(name = "tenant_id", discriminatorType = DiscriminatorType.INTEGER, contextProperty = PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ServiceItem implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_service_item")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="fk_destination")
    private Destination destination;

	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="fk_customerService")
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
    
    @Column(name="see_in")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date seeIn;
    
    @Column(name="requested_destination")
    private Boolean requestedDestination;
    
    @Column(name="negociation_observations")
    private String negociationObservations;

	public ServiceItem() {
		
	}

	public ServiceItem(Destination destination,
			CustomerService customerService, double valueNegotiated,
			SaleType saleType, Date departureDate, Date arrivalDate,
			Date seeIn,
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

	// Construtor para orçamento.
	public ServiceItem(Destination destination,
					   CustomerService cService,
					   Date departureDate,
					   Date arrivalDate,
					   String negociationObservations,
					   Date seeIn) {
		this.destination = destination;
		this.customerService = cService;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.negociationObservations = negociationObservations;
		this.setSeeIn(seeIn);
		this.saleType = SaleType.SEND_BUDGET;
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getSeeIn() {
		return seeIn;
	}

	public void setSeeIn(Date seeIn) {
		this.seeIn = seeIn;
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
		return Hashing.sha1().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
	       if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        final ServiceItem other = (ServiceItem) obj;
	        return Objects.equal(this.arrivalDate, other.arrivalDate)
	            && Objects.equal(this.departureDate, other.departureDate)
	            && Objects.equal(this.seeIn, other.seeIn)
	            && Objects.equal(this.tenantId, other.tenantId)
	            && Objects.equal(this.customerService, other.customerService)
	            && Objects.equal(this.saleType, other.saleType);
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(ServiceItem.class)
				.add("Destino negociado", getDestination().getDtName())
				.add("Tipo de Negociação", getSaleType()).toString();
	}
}