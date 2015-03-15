package br.com.joocebox.multitenancy;

import java.io.Serializable;

public interface CurrentTenantResolver<T extends Serializable> {
	
	T getCurrentTenantId();
	
	T getMasterTenantId();
	
	boolean isMasterTenant();
	
	boolean isSubDomainExist();

}
