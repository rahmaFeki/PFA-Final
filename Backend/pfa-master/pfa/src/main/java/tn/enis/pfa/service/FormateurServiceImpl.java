package tn.enis.pfa.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.entity.Formateur;
import tn.enis.pfa.repository.FormateurRepository;


@Service
public class FormateurServiceImpl implements FormateurService {
	@Autowired
	FormateurRepository formateurRepository;

	@Override
	public Formateur saveFormateur(Formateur d) {
	
		return formateurRepository.save(d);
	}

	@Override
	public void deleteFormateur(Formateur d) {
		formateurRepository.delete(d);
	}

	@Override
	public Formateur getFormateur(Long id) {
		return formateurRepository.findById(id).get();
	}

	@Override
	public List<Formateur> getAllFormateur() {
		List<Formateur> formateurs=formateurRepository.findAll();
	
	return formateurs;
	}

	@Override
	public void deleteFormateurById(Long id) {
		Formateur f=formateurRepository.findById(id).get();
		f.setDeleted(1);
		
		formateurRepository.save(f);

	}


}