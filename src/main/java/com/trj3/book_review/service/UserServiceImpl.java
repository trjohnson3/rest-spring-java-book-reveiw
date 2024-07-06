package com.trj3.book_review.service;

import com.trj3.book_review.converter.UserConverter;
import com.trj3.book_review.dto.UserDTO;
import com.trj3.book_review.entity.UserEntity;
import com.trj3.book_review.exception.ErrorModel;
import com.trj3.book_review.exception.UnauthorizedException;
import com.trj3.book_review.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO theUserDTO) {

        UserEntity myUserEntity = userConverter.convertToEntity(theUserDTO);
        myUserEntity = userRepository.save(myUserEntity);
        theUserDTO = userConverter.convertToDTO(myUserEntity);

        return theUserDTO;
    }

    @Override
    public UserDTO login(String theEmail, String thePassword) {

        Optional<UserEntity> myOptionalUserEntity = userRepository.findByEmailAndPassword(
                theEmail, thePassword);
        UserDTO myUserDTO = null;
        if(myOptionalUserEntity.isPresent()) {
            myUserDTO = userConverter.convertToDTO(myOptionalUserEntity.get());
        } else {
            List<ErrorModel> errorModelList = new ArrayList<>();
            ErrorModel errorModel = new ErrorModel();
            errorModel.setCode("INVALID_LOGIN");
            errorModel.setMessage("Incorrect email or password");
            errorModelList.add(errorModel);

            throw new UnauthorizedException(errorModelList);
        }

        return myUserDTO;
    }
}
