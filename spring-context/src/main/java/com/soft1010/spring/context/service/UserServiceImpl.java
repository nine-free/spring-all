package com.soft1010.spring.context.service;

import com.soft1010.spring.context.model.User;
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
}
