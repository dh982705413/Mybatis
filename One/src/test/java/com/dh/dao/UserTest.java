package com.dh.dao;

import com.dh.pojo.User;
import com.dh.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }
//    增删改需要提交事务
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.addUser(new User(5, "邓浩", "132456"));
        if(user>0){
            System.out.println("插入成功");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.updateUser(new User(4, "哈哈", "132456"));
        if(user>0){
            System.out.println("修改成功");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int user = mapper.deleteUser(5);
        if(user>0){
            System.out.println("删除成功");
        }
//        提交事务
        sqlSession.commit();
        sqlSession.close();
    }

}
