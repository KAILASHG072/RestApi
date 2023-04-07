package com.bike.repair.Controller.customer.service;

import java.util.List;
import java.util.Optional;

import com.bike.repair.Controller.customer.dto.ResponseUserDataDto;
import com.bike.repair.Controller.customer.dto.UserDataDto;
//import com.bike.repair.Controller.customer.entity.LoginData;
import com.bike.repair.Controller.customer.entity.UserData;

public interface CustomerService {

     ResponseUserDataDto add(UserDataDto user);

     Optional get(String username);

     void delete(String username);

     List <UserData> get();


}
