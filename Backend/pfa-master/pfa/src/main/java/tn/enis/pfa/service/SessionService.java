package tn.enis.pfa.service;

import java.util.List;

import tn.enis.pfa.entity.Session;


public interface SessionService {
	 Session saveSession(Session s);
	 Session updateSession(Session s);
	 void deleteSession(Session s);
	 void deleteSessionById(Long id);
	 Session getSession(Long id);
	 List<Session> getAllSession();
	 List<Session> getSessions(Long id);

}
