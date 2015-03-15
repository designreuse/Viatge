package br.com.joocebox.multitenancy;

public class TenantException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TenantException() {
		super();
	}

	public TenantException(String message) {
		super(message);
	}

}
