package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.repository.FormationRepository;
import tn.enis.pfa.entity.Formation;

@Service
public class FormationServiceImpl implements FormationService {
	@Autowired
	FormationRepository formationRepository;
	@Override
	public Formation saveFormation(Formation f) {
		// TODO Auto-generated method stub
		return formationRepository.save(f);
	}

	@Override
	public Formation updateFormation(Formation f) {
		// TODO Auto-generated method stub
		return formationRepository.save(f);
	}

	@Override
	public void deleteFormation(Formation f) {
		// TODO Auto-generated method stub
		formationRepository.delete(f);
	}

	@Override
	public void deleteFormationById(Long id) {
		formationRepository.deleteById(id);
		
	}

	@Override
	public Formation getFormation(Long id) {
		// TODO Auto-generated method stub
		return formationRepository.findById(id).get();
	}

	@Override
	public List<Formation> getAllFormation() {
		// TODO Auto-generated method stub
		return formationRepository.findAll();
	}

}
