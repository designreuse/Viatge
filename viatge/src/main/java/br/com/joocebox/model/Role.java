package br.com.joocebox.model;

import javax.validation.constraints.NotNull;

public enum Role {
	ROLE_MASTER("Mestre"),
	ROLE_USER("Operador"),
	ROLE_ADMIN("Administrador");
	
	@NotNull(message="Atribua uma regra de acesso ao sistema ao colaborador.")
	private final String role ;

	private Role(String role){
		this.role=role;
	}
	
	public String getRole(){
		return role;
	}
	
}
