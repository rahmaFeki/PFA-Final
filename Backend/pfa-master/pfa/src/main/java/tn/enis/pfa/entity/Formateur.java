package tn.enis.pfa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;
import javax.persistence.JoinColumn;

@Entity

@DiscriminatorValue("F")
public class Formateur extends User {

	private float salaire;

	@OneToMany(orphanRemoval = true, mappedBy = "formateur", cascade = CascadeType.PERSIST)
	private List<Disponibilite> disponibilites;
	@Where(clause = "deleted = 0")

	@ManyToMany
	@JoinTable(name = "formateur_specialite", joinColumns = {
			@JoinColumn(name = "formateur_id") }, inverseJoinColumns = { @JoinColumn(name = "specialite_id") })
	private List<Specialite> specialites;

	@OneToMany(mappedBy = "formateur")

	private List<Session> sessions;

	public Formateur() {
	}

	public Formateur(String nom, String prenom, String cin, String genre, String tel, String email, String motdepasse,
			Long idFormateur, float salaire) {
		super(nom, prenom, cin, genre, tel, email, motdepasse);
		this.salaire = salaire;

	}

	public void setDisponibilites(List<Disponibilite> disponibilites) {
		this.disponibilites = disponibilites;
	}

	public float getSalaire() {
		return salaire;
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

	public void setSalaire(float salaire) {
		this.salaire = salaire;
	}

	public List<Disponibilite> getDisponibilites() {
		return disponibilites;
	}

}