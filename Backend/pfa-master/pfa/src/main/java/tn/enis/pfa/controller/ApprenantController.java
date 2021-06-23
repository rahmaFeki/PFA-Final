package tn.enis.pfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.pfa.entity.Apprenant;
import tn.enis.pfa.entity.User;
import tn.enis.pfa.service.ApprenantServiceImpl;
import tn.enis.pfa.service.UserServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ApprenantController {

	@Autowired
	ApprenantServiceImpl apprenanteServiceImpl;
	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(method = RequestMethod.POST, value = "/appprenat")
	Apprenant addDomaine(@RequestBody Apprenant apprenant) {
		return apprenanteServiceImpl.saveApprenant(apprenant);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/appprenat/login")
	User login(@RequestBody Apprenant user) {
		System.out.println(user.getMotdepasse());
		return userServiceImpl.login(user);

	}
}
