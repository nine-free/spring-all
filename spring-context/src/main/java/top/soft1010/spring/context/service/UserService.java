package top.soft1010.spring.context.service;

import top.soft1010.spring.context.model.User;

import java.util.List;

/**
 * Created by jifuzhang on 17/8/11.
 */
public interface UserService {

    List<User> queryUser(String name);

    void saveUser(User user);
}
