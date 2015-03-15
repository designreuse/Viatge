package br.com.joocebox.multitenancy;

public interface Tenant<T> {
	
	T getTenantId();

}
