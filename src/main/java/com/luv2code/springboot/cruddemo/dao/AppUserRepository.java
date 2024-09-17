package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, String> {
}
