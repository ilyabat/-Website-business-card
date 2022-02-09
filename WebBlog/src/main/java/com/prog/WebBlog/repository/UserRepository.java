package com.prog.WebBlog.repository;

import com.prog.WebBlog.models.UserM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<UserM, Long>{

    UserM findByEmailAndPassword(String email, String password);
    Optional<UserM> findByLogin(String login);
}
