package com.map.common.mapper.system;

import com.map.common.entity.system.AuthUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthUserMapperTest {
    @Autowired
    private AuthUserMapper authUserMapper;

    @Test
    public void getUserByKeyTest(){
        authUserMapper.getUserByKey(5L);
    }

    @Test
    public void insertUserTest(){
        AuthUser authUser = new AuthUser();
        authUser.setCode("admin");
        authUser.setName("系统管理员");
        authUser.setPassword("admin");
        int i = authUserMapper.insertUser(authUser);
    }

    @Test
    public void deleteUserTest(){
        int i = authUserMapper.deleteUser(2L);
    }
}