package tn.enis.pfa.controller;

import java.awt.PageAttributes.MediaType;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.enis.pfa.entity.Domaine;
import tn.enis.pfa.entity.Formation;
import tn.enis.pfa.entity.Specialite;
import tn.enis.pfa.service.DomaineServiceImpl;
import tn.enis.pfa.service.FormationService;
import tn.enis.pfa.service.SpecialiteServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/formations")
public class FormationController {
	@Autowired
	FormationService FormationServiceImpl;
	@Autowired
	SpecialiteServiceImpl specialiteServiceImpl;
	private static String imageDirectory = System.getProperty("user.dir") + "\\src\\main\\resources\\images";

	@RequestMapping(method = RequestMethod.GET)
	public List<Formation> getAllFormation() {
		return FormationServiceImpl.getAllFormation();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Formation getFormationById(@PathVariable("id") Long id) {
		return FormationServiceImpl.getFormation(id);
	}

	@RequestMapping(method = RequestMethod.POST)

	public Formation createFormation(@RequestParam("img") MultipartFile file, @RequestParam("nom") String nom,
			@RequestParam("niveau") String niveau, @RequestParam("objectif") String objectif,
			@RequestParam("prix") float prix, @RequestParam("specialities") List<Long> specialites) {
		String img = null;
		System.out.println(specialites.toString());
		Path fileNamePath = Paths.get(imageDirectory, file.getOriginalFilename());
		System.out.println(fileNamePath);
		makeDirectoryIfNotExist(imageDirectory);

		try {
			Files.write(fileNamePath, file.getBytes());

		} catch (IOException ex) {
			System.out.println(ex.getStackTrace());
			return null;
		}
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			img = Base64.getEncoder().encodeToString(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Specialite> specialites1 = new ArrayList<Specialite>();
		Specialite e;
		for (int i = 0; i < specialites.size(); i++) {
			e = specialiteServiceImpl.getSpecialite(specialites.get(i));
			specialites1.add(e);
		}
		return FormationServiceImpl.saveFormation(new Formation(nom, img, niveau, prix, objectif, specialites1));

	}

	private void makeDirectoryIfNotExist(String imageDirectory) {
		File directory = new File(imageDirectory);
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Formation updateFormation(@RequestBody Formation formation) {
		Formation f = FormationServiceImpl.getFormation(formation.getIdFormation());
		f.setNom(formation.getNom());
		f.setImg(formation.getImg());
		f.setNiveau(formation.getNiveau());
		f.setPrix(formation.getPrix());
		f.setObjectif(formation.getObjectif());
		f.setEtat(formation.getEtat());
		f.setCouleur();
		return FormationServiceImpl.updateFormation(f);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteFormation(@PathVariable("id") Long id) {
		FormationServiceImpl.deleteFormationById(id);
	}

}
