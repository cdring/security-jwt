package com.chen.demo;
import java.util.Date;
import java.util.ArrayList;

import com.chen.demo.dto.User;
import com.chen.demo.dto.UserRepository;
import com.chen.demo.service.AuthServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void contextLoads() {
    }
    @Test
    public void testBCrypt() {
        String password = new BCryptPasswordEncoder().encode("123456");
        System.out.println(password);
    }
    @Test
    public void insertUser() {
        User user = new User();
        user.setId("1");
        user.setUsername("1");
        user.setPassword("2");
        user.setEmail("2");
        user.setLastPasswordResetDate(new Date());
        ArrayList<String> row1 = new ArrayList<> ();
        row1.add ("stuff1");
        user.setRoles(row1);
        userRepository.insert(user);




    }

}
