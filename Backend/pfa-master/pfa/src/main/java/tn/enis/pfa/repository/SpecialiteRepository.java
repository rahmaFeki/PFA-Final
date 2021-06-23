package tn.enis.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import tn.enis.pfa.entity.Specialite;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
	@Modifying
	@Query("DELETE Specialite s WHERE s.domaine.idDomaine = ?1")
	void deleteByDomaineId(int domaineId);

}
