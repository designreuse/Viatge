package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 * The persistent class for the street_view database table.
 * 
 */
@Entity
@Table(name="street_view")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class StreetView implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_street_view")
	private Long idStreetView;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	@Column(name="embedCode", length=4000)
	private String embedCode;
	
	@Column(name="src", length=2000)
	private String src;
	
	@Column(name="link")
	private String link;
	
	@Column(name="name")
	private String name;
	

	public StreetView() {
	}

	public Long getIdStreetView() {
		return idStreetView;
	}



	public void setIdStreetView(Long idStreetView) {
		this.idStreetView = idStreetView;
	}



	public Long getTenantId() {
		return tenantId;
	}



	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}



	public String getEmbedCode() {
		return embedCode;
	}



	public void setEmbedCode(String embedCode) {
		this.embedCode = embedCode;
	}



	public String getSrc() {
		return src;
	}



	public void setSrc(String src) {
		this.src = src;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}


}