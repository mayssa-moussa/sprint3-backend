package com.mayssa.etudiants.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Groupe;

@RepositoryRestResource(path="rest")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	List<Etudiant> findByNom(String nom);
	List<Etudiant> findByNomContains(String nom);
	@Query("select e from Etudiant e where e.nom like %?1 and e.prenom like %?2")
	List<Etudiant> findByNomPrenom (String nom, String prenom);
	//@Query("select e from Etudiant e where e.nom like %:nom and e.prenom like %:prenom")
	//List<Etudiant> findByNomPrenom (@Param("nom") String nom,@Param("prenom") String prenom);
	@Query("select e from Etudiant e where e.groupe = ?1")
	List<Etudiant> findByGroupe (Groupe groupe);
	List<Etudiant> findByGroupeIdGroupe(Long id);
	List<Etudiant> findByOrderByNomAsc();
	@Query("select e from Etudiant e order by e.nom ASC, e.dateNaiss DESC")
	List<Etudiant> trierEtudiantsNomDateNaiss ();
}
