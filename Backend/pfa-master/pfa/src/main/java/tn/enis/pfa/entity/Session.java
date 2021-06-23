package tn.enis.pfa.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

@Entity

public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private LocalDateTime start;

	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private LocalDateTime end;
	private String title;

	private int nbSeances;

	private int nbParticipant = 0;
	private String support;
	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private LocalDateTime dateExamen;
	@ManyToOne
	private Formation formation;

	@OneToMany(orphanRemoval = true, mappedBy = "session", cascade = CascadeType.PERSIST)
	private List<Seance> seances;

	@Where(clause = "deleted = 0")
	@ManyToOne
	private Formateur formateur;

	public Session() {

	}

	public Session(LocalDateTime start, LocalDateTime end, int nbParticipant, String support, LocalDateTime dateExamen,
			int nbSeances) {
		super();
		this.start = start;
		this.end = end;
		this.nbParticipant = nbParticipant;
		this.support = support;
		this.dateExamen = dateExamen;
		this.nbSeances = nbSeances;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNbSeance() {
		return nbSeances;
	}

	public void setNbSeance(int nbSeances) {
		this.nbSeances = nbSeances;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNbSeances() {
		return nbSeances;
	}

	public void setNbSeances(int nbSeances) {
		this.nbSeances = nbSeances;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	public int getNbParticipant() {
		return nbParticipant;
	}

	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}

	public String getSupport() {
		return support;
	}

	public void setSupport(String support) {
		this.support = support;
	}

	public LocalDateTime getDateExamen() {
		return dateExamen;
	}

	public void setDateExamen(LocalDateTime dateExamen) {
		this.dateExamen = dateExamen;
	}

}
