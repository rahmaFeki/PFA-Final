package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.entity.Domaine;
import tn.enis.pfa.repository.DomaineRepository;

@Service
public class DomaineServiceImpl implements DomaineService {
	@Autowired
	DomaineRepository domaineRepository;
	@Override
	public Domaine saveDomaine(Domaine d) {
		 
		return domaineRepository.save(d);
	}

	@Override
	public void deleteDomaine(Domaine d) {
		// TODO Auto-generated method stub
		domaineRepository.delete(d);	
	}

	@Override
	public void deleteDomaineById(Long id) {
		// TODO Auto-generated method stub
		domaineRepository.deleteById(id);
		
	}

	@Override
	public Domaine getDomaine(Long id) {
		// TODO Auto-generated method stub
		return domaineRepository.findById(id).get();
	}

	@Override
	public List<Domaine> getAllDomaines() {
		// TODO Auto-generated method stub
		return domaineRepository.findAll();
	}
	


}
