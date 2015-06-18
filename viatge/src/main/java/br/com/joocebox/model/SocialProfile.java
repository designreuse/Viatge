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
@Table(name="social_profile")
@Multitenant
@TenantDiscriminatorColumn(name="tenant_id", discriminatorType=DiscriminatorType.INTEGER, contextProperty=PersistenceUnitProperties.MULTITENANT_PROPERTY_DEFAULT)
public class SocialProfile implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_social")
	private Long id;
	
	@Column(name="tenant_id", insertable=false, updatable=false)
	private Long tenantId;
	
	private Boolean accompanying;
	private Boolean familyChildren;
	private Boolean elderly;
	private Boolean children;
	private Boolean friends;
	private Boolean alone;
	private Boolean teenager;
	
	public SocialProfile(){
		
	}
	
	public Long getId() {
		return id;
	}
	public Long getTenantId() {
		return tenantId;
	}
	public Boolean getAccompanying() {
		return accompanying;
	}
	public Boolean getElderly() {
		return elderly;
	}
	public Boolean getChildren() {
		return children;
	}
	public Boolean getFriends() {
		return friends;
	}
	public Boolean getAlone() {
		return alone;
	}
	public Boolean getTeenager() {
		return teenager;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTenantId(Long tenantId) {
		this.tenantId = tenantId;
	}
	public void setAccompanying(Boolean accompanying) {
		this.accompanying = accompanying;
	}
	public void setElderly(Boolean elderly) {
		this.elderly = elderly;
	}
	public void setChildren(Boolean children) {
		this.children = children;
	}
	public void setFriends(Boolean friends) {
		this.friends = friends;
	}
	public void setAlone(Boolean alone) {
		this.alone = alone;
	}
	public void setTeenager(Boolean teenager) {
		this.teenager = teenager;
	}

	public Boolean getFamilyChildren() {
		return familyChildren;
	}

	public void setFamilyChildren(Boolean familyChildren) {
		this.familyChildren = familyChildren;
	}
	
	@Override
	public String toString() {
		List<String> socialProfileList = new ArrayList<String>();
		
		if(Boolean.TRUE.equals(this.accompanying))
			socialProfileList.add("Acompanhantes");
		
		if(Boolean.TRUE.equals(this.alone))
			socialProfileList.add("Sozinho");
		
		if(Boolean.TRUE.equals(this.children))
			socialProfileList.add("Crianças");
		
		if(Boolean.TRUE.equals(this.elderly))
			socialProfileList.add("Idosos");
		
		if(Boolean.TRUE.equals(this.familyChildren))
			socialProfileList.add("Sem Crianças");
		
		if(Boolean.TRUE.equals(this.friends))
			socialProfileList.add("Amigos");
		
		if(Boolean.TRUE.equals(this.teenager))
			socialProfileList.add("Jovem");

		return "Adoro: " + Joiner.on(",").join(socialProfileList);
	}

}