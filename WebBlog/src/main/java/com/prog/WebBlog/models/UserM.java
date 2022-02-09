package com.prog.WebBlog.models;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Objects;

@Entity
public class UserM {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String login;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
       this.login = login;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserM userM = (UserM) o;
        return id.equals(userM.id) && login.equals(userM.login) && email.equals(userM.email) && password.equals(userM.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, email, password);
    }

    @Override
    public String toString() {
        return "UserM{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
