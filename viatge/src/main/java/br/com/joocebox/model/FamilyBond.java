package br.com.joocebox.model;

public enum FamilyBond {
	PARTNER("Cônjuge"),
	CHILDREN("Filho(a)"),
	DATE("Namorado(a)"),
	FRIEND("Amigo(a)"),
	PARENTS("Pai e/ou Mãe"),
	SIBLINGS("Irmão e/ou Irmã"),
	OTHER_PARENTS("Outros (Parentes)"),
	OTHER("Outros");
	
	private final String bond;
	
	private FamilyBond(String bond) {
		this.bond = bond;
	}

	public String getBond() {
		return bond;
	}
	
}
