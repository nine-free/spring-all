package com.soft1010.spring.service;


import com.soft1010.spring.model.User;

import java.util.List;

/**
 * Created by jifuzhang on 17/8/11.
 */
public interface UserService {

    List<User> queryUser(String name);

    void saveUser(User user);

    User getUserByName(String name);

    User getUserById(Long id);
}
