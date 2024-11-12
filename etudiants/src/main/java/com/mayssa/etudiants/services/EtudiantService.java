package com.mayssa.etudiants.services;

import java.util.List;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Groupe;


public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant e);

	Etudiant updateEtudiant(Etudiant e);

	void deleteEtudiant(Etudiant e);

	void deleteEtudiantById(Long id);

	Etudiant getEtudiant(Long id);

	List<Etudiant> getAllEtudiants();

	List<Etudiant> findByNom(String nom);

	List<Etudiant> findByNomContains(String nom);

	List<Etudiant> findByNomPrenom(String nom, String prenom);

	List<Etudiant> findByGroupe(Groupe groupe);

	List<Etudiant> findByGroupeIdGroupe(Long id);

	List<Etudiant> findByOrderByNomAsc();

	List<Etudiant> trierEtudiantsNomsPrenom();
	
}
