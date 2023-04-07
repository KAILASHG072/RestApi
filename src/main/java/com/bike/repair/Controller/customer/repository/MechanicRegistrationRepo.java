package com.bike.repair.Controller.customer.repository;
import com.bike.repair.Controller.customer.entity.MechanicData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRegistrationRepo extends JpaRepository<MechanicData,String>{
}
