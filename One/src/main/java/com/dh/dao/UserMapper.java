package com.dh.dao;

import com.dh.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
//    根据ID查询用户
    User getUserById(Integer id);
//    插入用户
    int addUser(User user);
//    修改用户
    int updateUser(User user);
//    删除用户
    int deleteUser(Integer id);
}
