package com.trj3.book_review.converter;

import com.trj3.book_review.dto.UserDTO;
import com.trj3.book_review.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertToEntity(UserDTO theUserDTO) {
        UserEntity myUserEntity = new UserEntity();
        myUserEntity.setEmail(theUserDTO.getEmail());
        myUserEntity.setUsername(theUserDTO.getUserName());
        myUserEntity.setPassword(theUserDTO.getPassword());

        return myUserEntity;
    }

    public UserDTO convertToDTO(UserEntity theUserEntity) {
        UserDTO myUserDTO = new UserDTO();
        myUserDTO.setId(theUserEntity.getId());
        myUserDTO.setEmail(theUserEntity.getEmail());
        myUserDTO.setUserName(theUserEntity.getUsername());

        return myUserDTO;
    }
}
