package top.soft1010.spring.context.service;

import org.springframework.context.Lifecycle;
import top.soft1010.spring.context.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jifuzhang on 17/8/11.
 */
@Service("userService")
@Lazy(value = false)
public class UserServiceImpl implements UserService,Lifecycle {

    private volatile boolean running = false;
    public List<User> queryUser(String name) {
        //TODO  query user
        System.out.println("name:" + name);
        return null;
    }

    public void saveUser(User user) {
        System.out.println(user == null ? null : user.toString());
        //TODO save user
    }

    public void start() {
        running = true;
        System.out.println("-----start---");
    }

    public void stop() {
        running = false;
        System.out.println("-----start---");
    }

    public boolean isRunning() {
        return running;
    }
}
