package tn.enis.pfa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity

@DiscriminatorValue("S")
public class Admin extends User {

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String nom, String prenom, String cin, String genre, String tel, String email, String motdepasse) {
		super(nom, prenom, cin, genre, tel, email, motdepasse);
		// TODO Auto-generated constructor stub
	}

}
