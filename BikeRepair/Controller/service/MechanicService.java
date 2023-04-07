package BikeRepair.Controller.service;

import BikeRepair.Controller.entity.MechanicData;


import java.util.List;
import java.util.Optional;

public interface MechanicService {

    MechanicData ToUser(String mechanic_name, String username);



    MechanicData add(MechanicData mechanic);

    Optional get(String mechanic);

    List get();
}
