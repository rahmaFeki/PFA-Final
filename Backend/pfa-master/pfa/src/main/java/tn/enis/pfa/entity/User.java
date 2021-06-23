package tn.enis.pfa.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SQLDelete(sql = "UPDATE User SET deleted = 1 WHERE idUser = ? and user_type='F'")
@Where(clause = "deleted = 0")
@DiscriminatorColumn(name = "user_type")
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long idUser;
	private String nom;
	private String prenom;
	private String cin;
	private String genre;
	private String tel;
	private String email;
	private String motdepasse;
	private int deleted = 0;

	public User() {
	}

	public User(String nom, String prenom, String cin, String genre, String tel, String email, String motdepasse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.genre = genre;
		this.tel = tel;
		this.email = email;
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getGenre() {
		return genre;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((motdepasse == null) ? 0 : motdepasse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (motdepasse == null) {
			if (other.motdepasse != null)
				return false;
		} else if (!motdepasse.equals(other.motdepasse))
			return false;
		return true;
	}

}