package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.entity.User;
import tn.enis.pfa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public User login(User u) {
		List<User> users = userRepository.findAll();
		for (User other : users) {
			if (other.equals(u)) {
				return other;
			}

		}
		return null;
	}

}