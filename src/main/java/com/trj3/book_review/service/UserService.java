package com.trj3.book_review.service;

import com.trj3.book_review.dto.UserDTO;

public interface UserService {

    UserDTO createUser(UserDTO theUserDTO);
    UserDTO login(String theEmail, String thePassword);
}
