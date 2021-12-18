package com.jg.interfaces;

import com.jg.pojo.User;

/**
 * @Author: Peekaboo
 * @Date: 2021/12/17 17:22
 * @Version 1.0
 */
public interface UserService {

    /**
     * 保存
     *
     * @param user
     */
    void save(User user);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 获取user
     * @return
     */
    default User getUser() {
        return new User();
    }

    default User getUser1() {
        return new User();
    }

}
