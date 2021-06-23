package tn.enis.pfa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import tn.enis.pfa.repository.SessionRepository;
import org.springframework.stereotype.Service;

import tn.enis.pfa.entity.Session;

@Service
public class SessionServiceImpl implements SessionService {
	@Autowired
	SessionRepository sessionRepository;

	@Override
	public Session saveSession(Session s) {
		return sessionRepository.save(s);
	}

	@Override
	public Session updateSession(Session s) {
		Session sessionUpdated=sessionRepository.findById(s.getId()).get();
		sessionUpdated.setStart(s.getStart());
		sessionUpdated.setEnd(s.getEnd());
		return sessionRepository.save(sessionUpdated);
	}

	@Override
	public void deleteSession(Session s) {
	sessionRepository.delete(s);
		
	}

	@Override
	public void deleteSessionById(Long id) {
		 sessionRepository.deleteById(id);
		
	}

	@Override
	public Session getSession(Long id) {
		return sessionRepository.findById(id).get();
	}

	@Override
	public List<Session> getAllSession() {
	
		return sessionRepository.findAll();
	}

	public List<Session> getSessions(Long id) {
		return sessionRepository.findByFormation(id);
	}



}
