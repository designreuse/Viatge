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
@Table(name="trip_profile")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class TripProfile implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_trip")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	private Boolean chill;
	private Boolean party;
	private Boolean gastronomy;
	private Boolean romance;
	private Boolean shopping;
	private Boolean fun;
	private Boolean history;
	private Boolean sports;
	private Boolean entertainment;
	
	public TripProfile(){
		
	}
	
	public Long getId() {
		return id;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public Boolean getChill() {
		return chill;
	}
	public Boolean getParty() {
		return party;
	}
	public Boolean getGastronomy() {
		return gastronomy;
	}
	public Boolean getRomance() {
		return romance;
	}
	public Boolean getShopping() {
		return shopping;
	}
	public Boolean getFun() {
		return fun;
	}
	public Boolean getHistory() {
		return history;
	}
	public Boolean getSports() {
		return sports;
	}
	public Boolean getEntertainment() {
		return entertainment;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public void setChill(Boolean chill) {
		this.chill = chill;
	}
	public void setParty(Boolean party) {
		this.party = party;
	}
	public void setGastronomy(Boolean gastronomy) {
		this.gastronomy = gastronomy;
	}
	public void setRomance(Boolean romance) {
		this.romance = romance;
	}
	public void setShopping(Boolean shopping) {
		this.shopping = shopping;
	}
	public void setFun(Boolean fun) {
		this.fun = fun;
	}
	public void setHistory(Boolean history) {
		this.history = history;
	}

	public void setSports(Boolean sports) {
		this.sports = sports;
	}
	public void setEntertainment(Boolean entertainment) {
		this.entertainment = entertainment;
	}
	
	@Override
	public String toString() {
		List<String> tripProfileList = new ArrayList<String>();
		
		if(Boolean.TRUE.equals(this.chill))
			tripProfileList.add("Descanso e Relax");
		
		if(Boolean.TRUE.equals(this.entertainment))
			tripProfileList.add("Parques Tematicos e Entretenimento");
		
		if(Boolean.TRUE.equals(this.fun))
			tripProfileList.add("Diversão e Aventura");
		
		if(Boolean.TRUE.equals(this.gastronomy))
			tripProfileList.add("Gastronomia e Culinária");
		
		if(Boolean.TRUE.equals(this.history))
			tripProfileList.add("História, Arte e Cultura");
		
		if(Boolean.TRUE.equals(this.party))
			tripProfileList.add("Festas e Vida Noturna");
		
		if(Boolean.TRUE.equals(this.romance))
			tripProfileList.add("Romance");
		
		if(Boolean.TRUE.equals(this.shopping))
			tripProfileList.add("Compras");
		
		if(Boolean.TRUE.equals(this.sports))
			tripProfileList.add("Ecoturismo e Esportes");

		return Joiner.on(",").join(tripProfileList);
	}
}