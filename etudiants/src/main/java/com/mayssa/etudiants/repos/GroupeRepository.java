package com.mayssa.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mayssa.etudiants.entities.Groupe;

@RepositoryRestResource(path="gp")//permet de générer automatiquement tous les api nécessaire pour la manipulation
@CrossOrigin("http://localhost:4200/")
public interface GroupeRepository extends JpaRepository<Groupe, Long>{

}
