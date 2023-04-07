package BikeRepair.Controller.repository;
import BikeRepair.Controller.entity.MechanicData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MechanicRegistrationRepo extends JpaRepository<MechanicData,String>{
}
