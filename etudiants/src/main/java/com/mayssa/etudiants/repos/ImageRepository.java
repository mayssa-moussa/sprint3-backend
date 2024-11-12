package com.mayssa.etudiants.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayssa.etudiants.entities.Image;

public interface ImageRepository  extends JpaRepository<Image , Long>{

}
