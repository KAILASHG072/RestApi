package com.bike.repair.Controller.customer.service;

import com.bike.repair.Controller.customer.entity.MechanicData;


import java.util.List;
import java.util.Optional;

public interface MechanicService {

    MechanicData ToUser(String mechanic_name, String username);



    MechanicData add(MechanicData mechanic);

    Optional get(String mechanic);

    List get();
}
