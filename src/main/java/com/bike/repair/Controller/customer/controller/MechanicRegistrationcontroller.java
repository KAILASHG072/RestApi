package com.bike.repair.Controller.customer.controller;


import com.bike.repair.Controller.customer.entity.MechanicData;
import com.bike.repair.Controller.customer.repository.RegistrationRepo;
import com.bike.repair.Controller.customer.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class MechanicRegistrationcontroller {
    @Autowired
    MechanicService mechanicService;
    @Autowired
    private RegistrationRepo registrationRepo;

    @PostMapping("/mechanics")
    public ResponseEntity<MechanicData> savemechanicdata(@RequestBody MechanicData mechanic) {
        try {
            return new ResponseEntity<MechanicData>(mechanicService.add(mechanic), HttpStatus.CREATED);
        } catch (Exception E) {
            return new ResponseEntity<MechanicData>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/mechanics")
    public ResponseEntity<List< MechanicData>> getallusers(){

        try{
            List list = mechanicService.get();
            if(list.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else return new  ResponseEntity<> (list, HttpStatus.OK);}
        catch (Exception e){
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);}
    }
    @PutMapping("/{mechanic_name}/user/{username}")
    public String AssignMechanicToUser(@PathVariable String mechanic_name , @PathVariable String username){
        mechanicService.ToUser(mechanic_name,username);
        return mechanic_name +" is assigned to " + username;
    }
}
