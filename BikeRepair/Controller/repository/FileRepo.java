package BikeRepair.Controller.repository;

import BikeRepair.Controller.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepo extends JpaRepository<FileDB, String> {
}
