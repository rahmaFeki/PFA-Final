package tn.enis.pfa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.pfa.entity.Formateur;
import tn.enis.pfa.service.FormateurServiceImpl;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class FormateurController {
	@Autowired
	FormateurServiceImpl formateurServiceImpl;

	@GetMapping("/formateurs")
	List<Formateur> getAllFormateur() {
		return formateurServiceImpl.getAllFormateur();
	}

	@RequestMapping(method = RequestMethod.POST, value = "/formateurs")
	Formateur addFormateur(@RequestBody Formateur formateur) {
		return formateurServiceImpl.saveFormateur(formateur);
	}
	

	@RequestMapping(value = "/formateurs", method = RequestMethod.PUT)
	public Formateur updateFormateur(@RequestBody Formateur formateur) {
		return formateurServiceImpl.saveFormateur(formateur);

	}
	@RequestMapping(value = "/formateurs/{id}", method = RequestMethod.PUT)
	public void updateFormateur(@PathVariable("id") Long id) {
		 formateurServiceImpl.deleteFormateurById(id);

	}
	@RequestMapping(value = "/formateurs/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteFormateur(@PathVariable("id") Long id) {
		formateurServiceImpl.deleteFormateurById(id);
	}

	@RequestMapping(value = "formateur/{id}", method = RequestMethod.GET)
	public Formateur getSpecialiteById(@PathVariable("id") Long id) {
		return formateurServiceImpl.getFormateur(id);
	}

}
