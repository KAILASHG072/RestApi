    package com.bike.repair.Controller.customer.controller;


    import com.bike.repair.Controller.customer.dto.ResponseUserDataDto;
    import com.bike.repair.Controller.customer.dto.UserDataDto;
    import com.bike.repair.Controller.customer.entity.UserData;
    import com.bike.repair.Controller.customer.service.CustomerService;
    import lombok.val;
    import org.springframework.security.core.Authentication;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.beans.factory.annotation.Autowired;

    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.web.bind.annotation.*;
    import javax.validation.Valid;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.Optional;
    @RestController
    public class UserRegistrationController {
        Logger log = LoggerFactory.getLogger(UserRegistrationController.class);

        @Autowired
        private AuthenticationManager authenticationManager;

        @Autowired
        CustomerService customerService;

        @PostMapping("/signin")
        public ResponseEntity<String> authenticateUser(@RequestBody UserData userData){

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userData.getUsername(),userData.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return new ResponseEntity<>("User signed-in successfully!.", HttpStatus.OK);
        }

        @PostMapping("/users") public ResponseEntity saveUserData(@Valid @RequestBody UserDataDto user)
        {
            try {
                log.info("Response: saving new user");
                ResponseUserDataDto response = customerService.add(user);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
                }
            catch (Exception e)
            { log.error("Exception occurred while creating product", e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @GetMapping("/users/{username}")
        public ResponseEntity<List<Object>> getUserData(@PathVariable String username) {
            log.info("Request {}", username);
            Optional<UserData> user = customerService.get(username);
            if (user.isPresent()) {
                UserData userData = user.get();
                List<Object> credentials = Arrays.asList(username, userData.getPassword(),userData.getAssignedmechanics());
                log.info("Response: {}", credentials);
                return ResponseEntity.ok(credentials);
            }
            return ResponseEntity.notFound().build();
        }


        @GetMapping("/users")
        public ResponseEntity<List<ResponseUserDataDto>> getAllUsers(){
            List list = customerService.get();
            if(list.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            log.info("Request {}",list);
            return ResponseEntity.ok(list);
        }


        @DeleteMapping("/users/{username}")
        public ResponseEntity<Void> deleteUserData(@PathVariable("username") String username) {
            log.info(username);
            try {
                customerService.delete(username);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                log.error("Error deleting user data for username {}", username, e);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

//        @RequestMapping("/signup") public  String signup(UserData user){
//            return "login";
//        }

        @RequestMapping("/login") public  String login(UserData user){
            return "login";
        }

    }
