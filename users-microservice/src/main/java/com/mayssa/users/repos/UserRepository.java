package com.mayssa.users.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayssa.users.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	Optional<User> findByEmail(String email);//retourne un user s'il existe si non ne retourne rien

}
