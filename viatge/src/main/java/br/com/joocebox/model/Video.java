package br.com.joocebox.model;

import java.io.Serializable;

import javax.persistence.*;

import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 * The persistent class for the video database table.
 * 
 */
@Entity
@Table(name="youtube_video")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_video")
	private Long idVideo;

	@Column(name="vd_cod")
	private String code;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;

	public Video() {
	}

//	public Long getIdVideo() {
//		return idVideo;
//	}

	public String getCode() {
		return code;
	}

	public Long getTenantId() {
		return tenantId;
	}

//	public void setIdVideo(Long idVideo) {
//		this.idVideo = idVideo;
//	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}



}