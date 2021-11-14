package com.learning.spring.learningspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDaoService service;

    // Get /users
    //retrieveAllUsers
    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // Get /users/{id}
    //retrieveUser
    @GetMapping("/users/{id}")
    public User retrieveUserById(@PathVariable int id) {
        User user = service.findUserById(id);
        if(user == null){
            throw new UserNotFoundException("id-" + id);
        }
        return service.findUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        User user = service.deleteById(id);
        if(user == null) {
            throw new UserNotFoundException("id-" + id);
        }
    }

    // CREATED
    // input - details of user
    // output - CREATED & Return the created URI
    @RequestMapping(path = "/users", method = {RequestMethod.POST, RequestMethod.PUT})
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);
        //CREATED
        // /user/{id}   savedUser.getId()
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
