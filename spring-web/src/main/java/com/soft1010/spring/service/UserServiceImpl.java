package com.soft1010.spring.service;

import com.soft1010.spring.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jifuzhang on 17/8/11.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    public List<User> queryUser(String name) {
        //TODO  query user
        System.out.println("name" + name);
        return null;
    }

    public void saveUser(User user) {
        System.out.println(user == null ? null : user.toString());
        //TODO save user
    }

    @Override
    public User getUserByName(String name) {
        //TODO
        User user = new User();
        user.setName(name);
        user.setAge(12);
        user.setEmail("*****@163.com");
        return user;
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhang");
        user.setAge(12);
        user.setEmail("*****@163.com");
        return user;
    }
}
