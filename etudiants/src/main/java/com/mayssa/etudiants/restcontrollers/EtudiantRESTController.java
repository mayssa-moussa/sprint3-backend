package com.mayssa.etudiants.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.services.EtudiantService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {
	@Autowired
	EtudiantService etudiantService;
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<Etudiant> getAllEtudiants(){
		return etudiantService.getAllEtudiants();
	}
	@GetMapping("/getbyid/{id}")
	public Etudiant getEtudiantById(@PathVariable("id") Long id) {
	return etudiantService.getEtudiant(id);
	 }
	
	@RequestMapping(path="/addetud",method = RequestMethod.POST)
	//@PreAuthorize("hasAuthority('ADMIN')")
	public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
	return etudiantService.saveEtudiant(etudiant);
	}
	@RequestMapping(path="/updateetud",method = RequestMethod.PUT)
	public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
	return etudiantService.updateEtudiant(etudiant);
	}
	@RequestMapping(value="/deletud/{id}",method = RequestMethod.DELETE)
	public void deleteEtudiant(@PathVariable("id") Long id)
	{
		etudiantService.deleteEtudiantById(id);
	}
	@RequestMapping(value="/etudgp/{idGroupe}",method = RequestMethod.GET)
	public List<Etudiant> getEtudiantsByGroupeId(@PathVariable("idGroupe") Long idGroupe) {
	return etudiantService.findByGroupeIdGroupe(idGroupe);
	}
	@RequestMapping(value="/etudsByName/{nom}",method = RequestMethod.GET)
	public List<Etudiant> findByNomContains(@PathVariable("nom") String nom) {
	return etudiantService.findByNomContains(nom);
	}
}
