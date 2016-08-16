package com.ujjwalsingh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ujjwalsingh.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {

	Users findByName(String name);
}
