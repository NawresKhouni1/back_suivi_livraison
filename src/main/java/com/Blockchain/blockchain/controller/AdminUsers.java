package com.Blockchain.blockchain.controller;


import java.util.Optional;  // Ensure this import is correct

// import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Blockchain.blockchain.entity.OurUsers;
import com.Blockchain.blockchain.repository.OurUserRepo;



@RestController
public class AdminUsers {

    @Autowired
    private OurUserRepo ourUserRepo;
  
    @GetMapping("/auth/confirm")
    public ResponseEntity<String> confirmUser(@RequestParam("email") String email) {
        Optional<OurUsers> userOptional = ourUserRepo.findByEmail(email);

        if (userOptional.isPresent()) {
            OurUsers user = userOptional.get();
            user.setConfirmed(true); // Mark the user as confirmed
            ourUserRepo.save(user);
            return ResponseEntity.ok("Account confirmed successfully!");
        } else {
            return ResponseEntity.status(404).body("User not found");
        }
    }



    @GetMapping("/user/alone")
    public ResponseEntity<Object> userAlone(){
        return ResponseEntity.ok("USers alone can access this ApI only");
    }

    @GetMapping("/adminuser/both")
    public ResponseEntity<Object> bothAdminaAndUsersApi(){
        return ResponseEntity.ok("Both Admin and Users Can  access the api");
    }

    /** You can use this to get the details(name,email,role,ip, e.t.c) of user accessing the service*/
    // @GetMapping("/public/email")
    // public String getCurrentUserEmail() {
    //     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    //     System.out.println(authentication); //get all details(name,email,password,roles e.t.c) of the user
    //     System.out.println(authentication.getDetails()); // get remote ip
    //     System.out.println(authentication.getName()); //returns the email because the email is the unique identifier
    //     return authentication.getName(); // returns the email
    // }

    @GetMapping("/public/userDetails")
    public ResponseEntity<Object> getCurrentUserDetails() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    System.out.println(authentication); // Get all details (name, email, password, roles, etc.) of the user
    System.out.println(authentication.getDetails()); // Get remote IP
    System.out.println(authentication.getName()); // Returns the email because the email is the unique identifier
    OurUsers userDetails = (OurUsers) authentication.getPrincipal();
    return ResponseEntity.ok(userDetails); // Returns the authenticated user details
}
}
