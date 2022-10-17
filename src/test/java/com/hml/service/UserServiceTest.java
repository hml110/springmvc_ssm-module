package com.hml.service;

import com.github.pagehelper.PageInfo;
import com.hml.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * @Description: service测试类
 * @ClassName: UserServiceTest
 * @Author: 25507
 * @Date: 2022-08-13 21:12
 * @Version: 1.0
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class UserServiceTest {
    //注入接口
    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setUserName("Jock");
        user.setPassword("root");
        user.setRealName("Jockme");
        user.setGender(1);
        user.setBirthday(new Date(333333000000L));

        userService.save(user);
    }

    @Test
    public void testDelete(){
        User user = new User();
        userService.delete(3);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setUuid(1);
        user.setUserName("Jockme");
        user.setPassword("root");
        user.setRealName("JockIsMe");
        user.setGender(1);
        user.setBirthday(new Date(333333000000L));

        userService.update(user);
    }

    @Test
    public void testGet(){
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAll(){
        PageInfo<User> all = userService.getAll(2, 2);
        System.out.println(all);
        System.out.println(all.getList().get(0));
        System.out.println(all.getList().get(1));
    }

    @Test
    public void testLogin(){
        User user = userService.login("Jockme", "root");
        System.out.println(user);
    }

}
