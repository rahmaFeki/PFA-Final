package tn.enis.pfa.service;

import java.util.List;

import tn.enis.pfa.entity.Formateur;


public interface FormateurService {

	Formateur saveFormateur(Formateur d);

	void deleteFormateur(Formateur d);

	Formateur getFormateur(Long id);

	List<Formateur> getAllFormateur();
	void deleteFormateurById(Long id);

}
