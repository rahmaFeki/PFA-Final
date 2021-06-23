package tn.enis.pfa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity

@DiscriminatorValue("A")
public class Apprenant extends User {

	@Enumerated(EnumType.STRING)
	private TypeApprenant type;

	public void setType(TypeApprenant type) {
		this.type = type;
	}

	public Apprenant() {
		super();
	}

	public Apprenant(String nom, String prenom, String cin, String genre, String tel, String email, String motdepasse) {
		super(nom, prenom, cin, genre, tel, email, motdepasse);
	}

	public TypeApprenant getType() {
		return type;
	}
}
