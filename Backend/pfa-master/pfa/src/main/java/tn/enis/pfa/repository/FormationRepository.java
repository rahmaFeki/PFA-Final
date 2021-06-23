package tn.enis.pfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enis.pfa.entity.Formation;
@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
