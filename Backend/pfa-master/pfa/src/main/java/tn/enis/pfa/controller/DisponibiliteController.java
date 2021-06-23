package tn.enis.pfa.controller;

import java.time.Instant;
import java.util.Date;
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

import tn.enis.pfa.entity.Disponibilite;
import tn.enis.pfa.service.DisponibiliteServiceImpl;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class DisponibiliteController {

	@Autowired
	DisponibiliteServiceImpl disponibiliteServiceImpl;

	@GetMapping("/disponibilites/{id}")
	List<Disponibilite> getDispoByFormateur(@PathVariable("id") Long idUser) {
		return  disponibiliteServiceImpl.getDispoByFormateur();
	}

	
}
