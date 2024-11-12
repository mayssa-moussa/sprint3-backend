package com.mayssa.etudiants.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Groupe;
import com.mayssa.etudiants.repos.EtudiantRepository;
import com.mayssa.etudiants.repos.ImageRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	/*
	 * @Override public Etudiant updateEtudiant(Etudiant e) { return
	 * etudiantRepository.save(e); }
	 */
	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		// Long oldEtudImageId =
		// this.getEtudiant(e.getIdEtudiant()).getImage().getIdImage();
		// Long newEtudImageId = e.getImage().getIdImage();
		Etudiant etudUpdated = etudiantRepository.save(e);
		// if (oldEtudImageId != newEtudImageId) //si l'image a été modifiée
		// imageRepository.deleteById(oldEtudImageId);
		return etudUpdated;
	}

	@Override
	public void deleteEtudiant(Etudiant e) {

		etudiantRepository.delete(e);

	}

	@Override
	public void deleteEtudiantById(Long id) {
		Etudiant etud = getEtudiant(id);
		// suuprimer l'image avant de supprimer l'étudiant
		try {
			Files.delete(Paths.get(System.getProperty("user.home") + "/images/" + etud.getImagePath()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		etudiantRepository.deleteById(id);

	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public List<Etudiant> findByNom(String nom) {
		return etudiantRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByNomContains(String nom) {
		return etudiantRepository.findByNomContains(nom);
	}

	@Override
	public List<Etudiant> findByNomPrenom(String nom, String prenom) {
		return etudiantRepository.findByNomPrenom(nom, prenom);
	}

	@Override
	public List<Etudiant> findByGroupe(Groupe groupe) {
		return etudiantRepository.findByGroupe(groupe);
	}

	@Override
	public List<Etudiant> findByGroupeIdGroupe(Long id) {
		return etudiantRepository.findByGroupeIdGroupe(id);
	}

	@Override
	public List<Etudiant> findByOrderByNomAsc() {
		return etudiantRepository.findByOrderByNomAsc();
	}

	@Override
	public List<Etudiant> trierEtudiantsNomsPrenom() {
		return etudiantRepository.trierEtudiantsNomDateNaiss();
	}

}
