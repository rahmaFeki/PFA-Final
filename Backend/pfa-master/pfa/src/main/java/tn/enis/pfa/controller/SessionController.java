package tn.enis.pfa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.enis.pfa.entity.Session;
import tn.enis.pfa.service.SessionServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/sessions")
public class SessionController {
	@Autowired
	SessionServiceImpl sessionServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public List<Session> getAllSpecialite() {
		return sessionServiceImpl.getAllSession();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Session> getSessions(@PathVariable("id") String id) {
		return sessionServiceImpl.getSessions(new Long(id));
	}

	@RequestMapping(method = RequestMethod.POST)
	public Session createSpecialite(@RequestBody Session session) {
		System.out.println(session.getFormateur());
		return sessionServiceImpl.saveSession(session);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Session updateSpecialite(@RequestBody Session session) {
		return sessionServiceImpl.updateSession(session);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteSession(@PathVariable("id") Long id) {
		sessionServiceImpl.deleteSessionById(id);
	}

}
