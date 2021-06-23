package tn.enis.pfa.service;

import java.util.List;

import tn.enis.pfa.entity.Specialite;
import tn.enis.pfa.entity.User;

public interface SpecialiteService {
	 Specialite saveSpecialite(Specialite s);
	 Specialite updateSpecialite(Specialite s);
	 void deleteSpecialite(Specialite s);
	 void deleteSpecialiteById(Long id);
	 Specialite getSpecialite(Long id);
	 List<Specialite> getAllSpecialite();
	
	
}
