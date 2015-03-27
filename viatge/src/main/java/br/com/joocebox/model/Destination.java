package br.com.joocebox.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;

import org.codehaus.jackson.annotate.JsonBackReference;
import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The persistent class for the destination database table.
 * 
 */
@Entity
@Table(name="destination")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT) 
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_destination")
	private Long idDestination;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;

	@Column(name="appear_website")
	private Boolean dtAppearWebsite;

	@Lob
	@Column(name="description")
	@NotEmpty(message="O campo \"Descrição do Destino\" não pode estar em branco.")
	private String dtDescription;

	@Column(name="highlight_website")
	private Boolean dtHighlightWebsite;

	@Column(name="name")
	@NotEmpty(message="O campo \"Nome do Destino\" não pode estar em branco.")
	private String dtName;
	
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="fk_street_view")
	private StreetView streetView;

	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="fk_video")
	private Video video;

	@ManyToOne(cascade=CascadeType.REFRESH)
	@JoinColumn(name="fk_category")
	@JsonBackReference
	private Category categories;

	//Profiles of System. These profiles are all enum type.
	@OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="fk_economic")
	private EconomicProfile economicProfiles;
	
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="fk_general")
	private GeneralProfile generalProfiles;

    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="fk_social")
	private SocialProfile socialProfiles;
	
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="fk_trip")
	private TripProfile tripProfiles;
	
    @OneToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="fk_weather")
	private WeatherProfile weatherprofile;
	//End of Profiles of System.
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_destination")
	@Valid
	private Set<Image> images;
	
	@OneToMany(mappedBy = "destination")
	private Set<ServiceItem> serviceItem;
	
	@OneToOne
	@JoinColumn(name="fk_country")
	private Country country;

	public Destination() {
	}

	public Long getIdDestination() {
		return this.idDestination;
	}

	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}

	public Boolean getDtAppearWebsite() {
		return this.dtAppearWebsite;
	}

	public void setDtAppearWebsite(Boolean dtAppearWebsite) {
		this.dtAppearWebsite = dtAppearWebsite;
	}

	public String getDtDescription() {
		return this.dtDescription;
	}

	public void setDtDescription(String dtDescription) {
		this.dtDescription = dtDescription;
	}

	public Boolean getDtHighlightWebsite() {
		return this.dtHighlightWebsite;
	}

	public void setDtHighlightWebsite(Boolean dtHighlightWebsite) {
		this.dtHighlightWebsite = dtHighlightWebsite;
	}

	public String getDtName() {
		return this.dtName;
	}

	public void setDtName(String dtName) {
		this.dtName = dtName;
	}

	public EconomicProfile getEconomicProfiles() {
		return this.economicProfiles;
	}

	public void setEconomicProfiles(EconomicProfile economicProfiles) {
		this.economicProfiles = economicProfiles;
	}

	public GeneralProfile getGeneralProfiles() {
		return this.generalProfiles;
	}

	public void setGeneralProfiles(GeneralProfile generalProfiles) {
		this.generalProfiles = generalProfiles;
	}

	public Set<Image> getImages() {
		return this.images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public SocialProfile getSocialProfiles() {
		return this.socialProfiles;
	}

	public void setSocialProfiles(SocialProfile socialProfiles) {
		this.socialProfiles = socialProfiles;
	}

	public TripProfile getTripProfiles() {
		return this.tripProfiles;
	}

	public void setTripProfiles(TripProfile tripProfiles) {
		this.tripProfiles = tripProfiles;
	}

	public Long getTenantId() {
		return tenantId;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public StreetView getStreetView() {
		return streetView;
	}

	public void setStreetView(StreetView streetView) {
		this.streetView = streetView;
	}

	public WeatherProfile getWeatherprofile() {
		return weatherprofile;
	}

	public void setWeatherprofile(WeatherProfile weatherprofile) {
		this.weatherprofile = weatherprofile;
	}
	
	public Category getCategories() {
		return categories;
	}

	public void setCategories(Category categories) {
		this.categories = categories;
	}

	public Set<ServiceItem> getServiceItem() {
		return serviceItem;
	}

	public void setServiceItem(Set<ServiceItem> serviceItem) {
		this.serviceItem = serviceItem;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}