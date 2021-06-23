package tn.enis.pfa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Domaine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDomaine;
	private String nom;

	@OneToMany(orphanRemoval = true, mappedBy = "domaine", cascade = CascadeType.PERSIST)

	private List<Specialite> specialites;

	public Domaine() {
		super();
	}

	public Domaine(String nom) {
		super();
		this.nom = nom;
	}

	public Long getIdDomaine() {
		return idDomaine;
	}

	public void setIdDomaine(Long idDomaine) {
		this.idDomaine = idDomaine;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
