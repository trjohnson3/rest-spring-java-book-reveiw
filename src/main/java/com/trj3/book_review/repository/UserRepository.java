package com.trj3.book_review.repository;

import com.trj3.book_review.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailAndPassword(String theEmail, String thePassword);
}
