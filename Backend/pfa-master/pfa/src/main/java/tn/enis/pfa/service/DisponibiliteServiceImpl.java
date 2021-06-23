package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.pfa.entity.Disponibilite;

import tn.enis.pfa.repository.DisponibiliteRepository;

@Service
public class DisponibiliteServiceImpl implements DisponibiliteService {
	@Autowired
	DisponibiliteRepository disponibiliteRepository;

	@Override
	public List<Disponibilite> getDispoByFormateur() {
		// TODO Auto-generated method stub
		return  disponibiliteRepository.findAll();
	}
	
	


}
