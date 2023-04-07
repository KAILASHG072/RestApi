package com.bike.repair.Controller.customer.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bike.repair.Controller.customer.entity.UserData;

import java.util.Optional;


@Repository
public interface RegistrationRepo extends JpaRepository<UserData,String> {

   Optional<UserData> findByUsername(String username);
}