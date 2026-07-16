package com.devteria.data_encryption_demo.entity;

import com.devteria.data_encryption_demo.converter.BCryptConverter;
import com.devteria.data_encryption_demo.converter.EncryptConverter;
import jakarta.persistence.*;

@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "username", unique = true)
    private String username;

    @Convert(converter = EncryptConverter.class)
    @Column(name = "full_name")
    private String fullName;

    @Convert(converter = EncryptConverter.class)
    @Column(name = "email")
    private String email;

    @Convert(converter = BCryptConverter.class)
    @Column(name = "password")
    private String password;

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
