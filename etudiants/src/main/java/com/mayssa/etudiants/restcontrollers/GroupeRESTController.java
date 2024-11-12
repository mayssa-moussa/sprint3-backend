package com.mayssa.etudiants.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mayssa.etudiants.entities.Groupe;
import com.mayssa.etudiants.repos.GroupeRepository;

@RestController
@RequestMapping("/api/gp")
@CrossOrigin("*")

public class GroupeRESTController {
	@Autowired
	GroupeRepository groupeRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Groupe> getAllGroupes()
	{
	return groupeRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Groupe getGroupeById(@PathVariable("id") Long id) {
	return groupeRepository.findById(id).get();
	}

}
