package com.laraakhil.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.laraakhil.springsecurity.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	Optional<User> findByUserName(String userName);

}
