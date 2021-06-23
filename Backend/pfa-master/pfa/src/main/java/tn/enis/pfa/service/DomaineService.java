package tn.enis.pfa.service;

import java.util.List;

import tn.enis.pfa.entity.Domaine;


public interface DomaineService {

	Domaine saveDomaine(Domaine d);

	void deleteDomaine(Domaine d);
	void deleteDomaineById(Long id);

	Domaine getDomaine(Long id);

	List<Domaine> getAllDomaines();
}