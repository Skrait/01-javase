package com.jg.test;

import com.jg.interfaces.impl.UserServiceImpl;
import com.jg.pojo.User;
import org.junit.Test;

/**
 * @Author: Peekaboo
 * @Date: 2021/12/17 17:22
 * @Version 1.0
 */
public class InterfaceTest {

    @Test
    public void testInterfaceDefault() {
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.getUser();
        User user1 = userService.getUser1();
        User byId = userService.findById(1);
        System.out.println(user);
        System.out.println(user1);
        System.out.println(byId);
    }

}
