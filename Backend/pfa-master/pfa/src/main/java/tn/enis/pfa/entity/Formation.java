package tn.enis.pfa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Formation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFormation;
	private String nom;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String img;
	private String niveau;
	private float prix;
	private String objectif;
	private String couleur;
	@Enumerated(EnumType.STRING)
	private TypeFormation etat;

	@ManyToMany
	@JoinTable(name = "formation_specialite", joinColumns = {
			@JoinColumn(name = "id_formation") }, inverseJoinColumns = { @JoinColumn(name = "specialite_id") })
	private List<Specialite> specialites;

	public Formation(String nom, String img, String niveau, float prix, String objectif, List<Specialite> specialites) {
		super();
		this.nom = nom;
		this.niveau = niveau;
		this.etat = TypeFormation.crée;
		this.prix = prix;
		this.objectif = objectif;
		this.img = img;
		this.specialites = specialites;
		setCouleur();
	}

	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCouleur() {
		return couleur;

	}

	public void setCouleur() {
		if (etat.equals(TypeFormation.crée))
			couleur = "blue";
		if (etat.equals(TypeFormation.lancée))
			couleur = "orange";
		if (etat.equals(TypeFormation.achevée))
			couleur = "green";
	}

	public List<Specialite> getSpecialites() {
		return specialites;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public void setSpecialites(List<Specialite> specialites) {
		this.specialites = specialites;
	}

	@OneToMany(orphanRemoval = true, mappedBy = "formation", cascade = CascadeType.PERSIST)
	private List<Session> sessions;

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public TypeFormation getEtat() {
		return etat;
	}

	public void setEtat(TypeFormation etat) {
		this.etat = etat;

	}

	public Long getIdFormation() {
		return idFormation;
	}

	public void setIdFormation(Long idFormation) {
		this.idFormation = idFormation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	};

}
