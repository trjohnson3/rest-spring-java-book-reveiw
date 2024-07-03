package com.trj3.book_review.controller;

import com.trj3.book_review.dto.UserDTO;
import com.trj3.book_review.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO theUserDTO) {

        theUserDTO = userService.createUser(theUserDTO);
        return new ResponseEntity<UserDTO>(theUserDTO, HttpStatus.CREATED);
    }
}
