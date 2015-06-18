package br.com.joocebox.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

import com.google.common.base.Joiner;

@Entity
@Table(name="weather_profile")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class WeatherProfile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_weather")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	private Boolean heat;
	private Boolean cold;
	private Boolean winter;
	
	public WeatherProfile(){
		
	}
	
	public Long getId() {
		return id;
	}

	public Long getTenantId() {
		return tenantId;
	}
	public Boolean getHeat() {
		return heat;
	}
	public Boolean getCold() {
		return cold;
	}
	public Boolean getWinter() {
		return winter;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public void setHeat(Boolean heat) {
		this.heat = heat;
	}
	public void setCold(Boolean cold) {
		this.cold = cold;
	}
	public void setWinter(Boolean winter) {
		this.winter = winter;
	}
	
	@Override
	public String toString() {
		List<String> weatherProfileList = new ArrayList<String>();
		
		if(Boolean.TRUE.equals(this.cold))
			weatherProfileList.add("Frio");
		
		if(Boolean.TRUE.equals(this.heat))
			weatherProfileList.add("Calor");
		
		if(Boolean.TRUE.equals(this.winter))
			weatherProfileList.add("Frio e Neve");

		return "Prefiro: " + Joiner.on(",").join(weatherProfileList);
	}

}