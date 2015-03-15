package br.com.joocebox.utils;

public class JooceBoxProperties {
	public String pathTenants;
	public String pathLogoTenants;

	public JooceBoxProperties() {
		this.pathTenants = "/app/joocebox-img/";
	}
	
	public String getPathTenants(){
		return this.pathTenants;
	}
	
	public String getPathLogoTenants(String domain){
		return this.pathTenants+domain+"/logo";
	}
	
	public String getPathOriginalImages(String domain){
		return this.pathTenants+domain+"/destination/original/";
	}
	
	public String getPathThumbnailImage(String domain){
		return this.pathTenants+domain+"/destination/thumbnail/";
	}
	
	public String getPathResizedImage(String domain){
		return this.pathTenants+domain+"/destination/resizedImages/";
	}
	
}
