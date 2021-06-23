package tn.enis.pfa.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Seance {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSession;
	@DateTimeFormat(pattern = "yyyy.MM.dd HH:mm:ss")
	private LocalDateTime dateSeance;
	@ManyToOne
	private Session session;

	public Seance() {

	}

	public Seance(Long idSession, LocalDateTime date_seance) {
		super();
		this.idSession = idSession;
		this.dateSeance = date_seance;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Long getIdSession() {
		return idSession;
	}

	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}

	public LocalDateTime getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(LocalDateTime date_seance) {
		this.dateSeance = date_seance;
	}

}
