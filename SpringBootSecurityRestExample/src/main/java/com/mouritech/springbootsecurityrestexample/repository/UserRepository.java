package com.mouritech.springbootsecurityrestexample.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mouritech.springbootsecurityrestexample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsernameOrEmail(String usernameOrEmail, String usernameOrEmail2);



}
