package tn.enis.pfa.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.pfa.entity.Domaine;
import tn.enis.pfa.service.DomaineServiceImpl;
import tn.enis.pfa.service.SpecialiteServiceImpl;
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DomaineRESTController {

	@Autowired
	DomaineServiceImpl domaineServiceImpl;


	
	@GetMapping("/domaines")
	List<Domaine> getAllDomaines() {
		return domaineServiceImpl.getAllDomaines();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/domaines")
	Domaine addDomaine(@RequestBody Domaine domaine) {
		
		return domaineServiceImpl.saveDomaine(domaine);
	}
		
	@RequestMapping(value = "/domaines",method = RequestMethod.PUT)
	public Domaine updateDomaine(@RequestBody Domaine domaine) {
		 Domaine d=domaineServiceImpl.getDomaine(domaine.getIdDomaine());
		 d.setNom(domaine.getNom());
		
		 
		return domaineServiceImpl.saveDomaine(d);
		
	}

	@RequestMapping(value = "/domaines/{id}", method = RequestMethod.DELETE)
	public void deleteDomaine(@PathVariable("id") Long id) {
	
		domaineServiceImpl.deleteDomaineById(id);
	}

}
