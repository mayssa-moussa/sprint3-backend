package com.mayssa.etudiants.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long idEtudiant;
	private String nom;
	private String prenom;
	private Date dateNaiss;
	private String email;
	private String classe;
	@ManyToOne
	private Groupe groupe;
	/*
	 * @OneToOne private Image image;
	 */
	 @OneToMany (mappedBy = "etudiant")
	 private List<Image> images;
	 
	 private String imagePath;


	

}
