package com.jg.interfaces.impl;

import com.jg.data.UserData;
import com.jg.interfaces.UserService;
import com.jg.pojo.User;

import java.util.List;

/**
 * @Author: Peekaboo
 * @Date: 2021/12/17 17:22
 * @Version 1.0
 */
public class UserServiceImpl implements UserService {
    public void save(User user) {
        System.out.println("保存方法被调用");
    }

    public User findById(Integer id) {
        List<User> userList = UserData.userList;
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
