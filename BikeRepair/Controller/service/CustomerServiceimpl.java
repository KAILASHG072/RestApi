package BikeRepair.Controller.service;

import java.util.List;
import java.util.Optional;

import BikeRepair.Controller.dto.ResponseUserDataDto;
import BikeRepair.Controller.dto.UserDataDto;
import BikeRepair.Controller.entity.UserData;
import BikeRepair.Controller.repository.RegistrationRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl  implements CustomerService{

    Logger log = LoggerFactory.getLogger(CustomerServiceimpl.class);

    @Autowired
    RegistrationRepo registrationRepo;
    @Override
    public ResponseUserDataDto add(UserDataDto user) {
        log.info("Adding user: {}", user);
        UserData userData = new UserData();
        BeanUtils.copyProperties(user, userData);
        log.info("Created user data: {}", userData);
        userData = registrationRepo.save(userData);
        ResponseUserDataDto responseUserDataDto = new ResponseUserDataDto();
        BeanUtils.copyProperties(userData, responseUserDataDto);
        return responseUserDataDto;
    }

    @Override
    public Optional get(String username) {
        return registrationRepo.findById(username);}

    @Override
    public void delete(String username) {
        if (get(username).isPresent()){
            registrationRepo.delete((UserData) get(username).get());}
    }

    @Override
    public List <UserData>get() {
        return registrationRepo.findAll();
    }



   //    @Override
//    public List<LoginData> getallForEmail() {
//        return loginRepo.findAll();
//    }
//
//    @Override
//    public LoginData addExcel(LoginData user) {
//        return null;
//    }
//
//    @Override
//    public List<LoginData> getallusers() {
//        return loginRepo.findAll();
//    }


}
