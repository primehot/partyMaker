package com.partyMaker.partyMaker.repository;

import com.partyMaker.partyMaker.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findById(Integer id);
    UserEntity findByName(String name);
}
