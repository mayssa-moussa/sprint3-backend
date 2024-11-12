package com.mayssa.etudiants.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //pour générer les getters et les setters
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Groupe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGroupe;
	private String nomGroupe;
	@JsonIgnore
	@OneToMany(mappedBy = "groupe")
	private List<Etudiant> etudiants;

	

}
