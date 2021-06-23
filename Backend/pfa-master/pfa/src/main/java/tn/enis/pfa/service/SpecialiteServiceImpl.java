package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.repository.SpecialiteRepository;
import tn.enis.pfa.entity.Specialite;

@Service
public class SpecialiteServiceImpl implements SpecialiteService {
	@Autowired
	SpecialiteRepository specialiteRepository;

	@Override
	public Specialite saveSpecialite(Specialite s) {
		// TODO Auto-generated method stub
		return specialiteRepository.save(s);
	}

	@Override
	public Specialite updateSpecialite(Specialite s) {
		// TODO Auto-generated method stub
		return specialiteRepository.save(s);
	}

	@Override
	public void deleteSpecialite(Specialite s) {
		// TODO Auto-generated method stub
		specialiteRepository.delete(s);
	}

	@Override
	public void deleteSpecialiteById(Long id) {
		// TODO Auto-generated method stub
		specialiteRepository.deleteById(id);

	}



	@Override
	public Specialite getSpecialite(Long id) {
		// TODO Auto-generated method stub
		return specialiteRepository.findById(id).get();
	}

	@Override
	public List<Specialite> getAllSpecialite() {
		// TODO Auto-generated method stub
		return specialiteRepository.findAll();
	}

}
