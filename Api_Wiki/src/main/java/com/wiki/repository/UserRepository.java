package com.wiki.repository;


import com.wiki.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<Users, Long> {

    Users findByUsernameAndPassword(String username, String password);

    List<Users> findByTypeNot(String type);

    Users findByUsername(String username);

    Users findByEmail(String email);
}
