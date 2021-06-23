package tn.enis.pfa.service;

import java.util.List;

import tn.enis.pfa.entity.Formation;

public interface FormationService {
	 Formation saveFormation(Formation f);
	 Formation updateFormation(Formation f);
	 void deleteFormation(Formation f);
	 void deleteFormationById(Long id);
	 Formation getFormation(Long id);
	 List<Formation> getAllFormation();

}
