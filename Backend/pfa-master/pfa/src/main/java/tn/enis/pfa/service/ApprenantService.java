package tn.enis.pfa.service;

import tn.enis.pfa.entity.Apprenant;
import tn.enis.pfa.entity.User;

public interface ApprenantService {
	Apprenant saveApprenant(Apprenant a);

	public User getUser(String username);
}
