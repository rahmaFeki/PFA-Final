package tn.enis.pfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.pfa.entity.Specialite;
import tn.enis.pfa.service.SpecialiteServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/Specialites")
public class SpecialiteController {
	@Autowired
	SpecialiteServiceImpl specialiteServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public List<Specialite> getAllSpecialite() {
		return specialiteServiceImpl.getAllSpecialite();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Specialite getSpecialiteById(@PathVariable("id") Long id) {
		return specialiteServiceImpl.getSpecialite(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Specialite createSpecialite(@RequestBody Specialite specialite) {
		return specialiteServiceImpl.saveSpecialite(specialite);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Specialite updateSpecialite(@RequestBody Specialite specialite) {
		return specialiteServiceImpl.updateSpecialite(specialite);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSpecialite(@PathVariable("id") Long id) {
		specialiteServiceImpl.deleteSpecialiteById(id);
	}
	

}
