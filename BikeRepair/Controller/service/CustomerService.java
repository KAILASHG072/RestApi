package BikeRepair.Controller.service;

import java.util.List;
import java.util.Optional;

import BikeRepair.Controller.dto.ResponseUserDataDto;
import BikeRepair.Controller.dto.UserDataDto;
import BikeRepair.Controller.entity.UserData;
//import com.bike.repair.Controller.customer.entity.LoginData;


public interface CustomerService {

     ResponseUserDataDto add(UserDataDto user);

     Optional get(String username);

     void delete(String username);

     List <UserData> get();


}
