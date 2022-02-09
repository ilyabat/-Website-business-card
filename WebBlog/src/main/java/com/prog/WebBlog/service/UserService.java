package com.prog.WebBlog.service;

import com.prog.WebBlog.models.UserM;
import com.prog.WebBlog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserService {

private final UserRepository repo;
    @Autowired
    public UserService(UserRepository repo){
        this.repo = repo;
    }

    public UserM registerUser(String login, String password, String email){
        if (login == null || password == null){
            return null;
        }else {
            if (repo.findByLogin(login).isPresent()){
                System.out.println("Такий логін же існує");
                return null;
            }
            if (repo.findByLogin(email).isPresent()){
                System.out.println("Дана пошта вже зареєстрована");
                return null;
            }
            UserM userM = new UserM();
            userM.setLogin(login);
            userM.setEmail(email);
            userM.setPassword(password);
            return repo.save(userM);
        }
    }
    public UserM authenticate(String email, String password){
        if (repo.findByEmailAndPassword(email, password) == null){
            return null;
        }else {
            return repo.findByEmailAndPassword(email,password);
        }
    }


}
