package BikeRepair.Controller.service;

import BikeRepair.Controller.repository.MechanicRegistrationRepo;
import BikeRepair.Controller.repository.RegistrationRepo;
import BikeRepair.Controller.entity.MechanicData;
import BikeRepair.Controller.entity.UserData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MechanicServiceImpl implements MechanicService {

    @Autowired
    MechanicRegistrationRepo mechanicregistrationRepo;

    @Autowired
    RegistrationRepo registrationRepo;

 @Override
    public MechanicData ToUser(String mechanic_name, String username) {
        Set<UserData> userDataSet=null;
       MechanicData mechanic= mechanicregistrationRepo.findById(mechanic_name).get();
       UserData user= registrationRepo.findById(username).get();
       userDataSet=mechanic.getUsers_set();
       userDataSet.add(user);
       mechanic.setUsers_set(userDataSet);
        return mechanicregistrationRepo.save(mechanic);}

    @Override
    public MechanicData add(MechanicData mechanic) {
       return mechanicregistrationRepo.save(mechanic);
    }

    @Override
    public Optional get(String mechanic) {
        return mechanicregistrationRepo.findById(mechanic);
    }

    @Override
    public List get() { return mechanicregistrationRepo.findAll();}



}


