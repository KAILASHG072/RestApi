package com.bike.repair.Controller.customer.repository;

import com.bike.repair.Controller.customer.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileDB, String> {
}
