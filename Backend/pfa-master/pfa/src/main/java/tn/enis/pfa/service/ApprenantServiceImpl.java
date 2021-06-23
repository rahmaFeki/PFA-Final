package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.entity.Apprenant;
import tn.enis.pfa.entity.User;
import tn.enis.pfa.repository.ApprenantRepository;
import tn.enis.pfa.repository.UserRepository;

@Service
public class ApprenantServiceImpl implements ApprenantService {
	@Autowired
	ApprenantRepository apprenantRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public Apprenant saveApprenant(Apprenant a) {

		return apprenantRepository.save(a);
	}

	@Override
	public User getUser(String username) {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.getNom().equals(username)) {
				return user;
			}
		}
		return null;
	}
}
