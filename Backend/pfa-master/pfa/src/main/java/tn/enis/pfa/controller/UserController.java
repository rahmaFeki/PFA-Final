package tn.enis.pfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.pfa.entity.Admin;
import tn.enis.pfa.entity.User;
import tn.enis.pfa.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	User login(@RequestBody Admin user) {
		System.out.println(user.getMotdepasse());
		return userServiceImpl.login(user);

	}
}
