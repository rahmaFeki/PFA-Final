package tn.enis.pfa.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.enis.pfa.entity.Session;
public interface SessionRepository extends JpaRepository<Session, Long> {
	@Query("SELECT s FROM Session s WHERE s.formation.idFormation = ?1")
	List<Session> findByFormation(long id);

}
