package com.soft1010.spring.model;

import java.io.Serializable;

/**
 * Created by jifuzhang on 17/8/11.
 */
public class User implements Serializable{

    private Long id;
    private String name;
    private String email;
    private String phone;
    private Integer age;

    public User() {
    }

    public User(String name, String email, String phone, Integer age) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
