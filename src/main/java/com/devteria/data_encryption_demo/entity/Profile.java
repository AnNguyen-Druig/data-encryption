package com.devteria.data_encryption_demo.entity;

import com.devteria.data_encryption_demo.converter.EncryptConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username")
    private String username;

    @Column(name = "full_name")
    @Convert(converter = EncryptConverter.class)
    private String fullName;

    @Column(name = "email")
    @Convert(converter = EncryptConverter.class)
    private String email;

    @Column(name = "password")
    @Convert(converter = EncryptConverter.class)
    private String password;

    public Profile(String id, String username, String fullName, String email, String password) {
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public Profile() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
