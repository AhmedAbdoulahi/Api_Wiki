package com.wiki.controller;


import com.wiki.entities.Users;
import com.wiki.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userservice;

    @GetMapping
    public List<Users> getAllusers() {
        return userservice.getAllUsers();
    }
    @PutMapping("/updatetype/{id}")
    public ResponseEntity<Users> updatetypeuser(@PathVariable(value = "id") Long id, @RequestBody Users user) {
       Users userupdated = userservice.updateUserType(id,user);
        if (userupdated != null) {
            return ResponseEntity.ok(userupdated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/SignIn")
    public ResponseEntity<?> signInUser(@RequestBody Users user) {
        Users usersignIn = userservice.signin(user);
        if (usersignIn != null) {
            return ResponseEntity.ok(usersignIn);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants incorrects. Veuillez vérifier votre nom d'utilisateur et votre mot de passe.");
        }
    }

    @PostMapping("/SignUp")
    public ResponseEntity<?> signUpUser(@RequestBody Users user) {

        if (userservice.getUserbyemail(user.getEmail())!=null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Un compte avec cet e-mail existe déjà.");
        }

        // Vérifier si le nom d'utilisateur existe déjà
        if (userservice.getUserbyusername(user.getUsername())!=null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ce nom d'utilisateur est déjà utilisé.");
        }

        // Créer un nouvel utilisateur
        userservice.signup(user);
        return ResponseEntity.ok(user);

    }
    @GetMapping("/getuser/{id}")
    public ResponseEntity<Users> getuserbyid(@PathVariable(value = "id") Long id)
    {
        Users user = userservice.getUserbyid(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
