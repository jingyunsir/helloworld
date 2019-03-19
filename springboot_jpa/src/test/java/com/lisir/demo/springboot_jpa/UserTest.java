package com.lisir.demo.springboot_jpa;

import com.lisir.demo.springboot_jpa.domain.User;
import com.lisir.demo.springboot_jpa.repostory.UserReporstory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class UserTest {
    @Autowired
    private UserReporstory userReporstory;
    @Test
    public void test(){
        User login = userReporstory.findAllByNameEqualsAndPasswordEquals("admin", "admin");
        System.out.println(login);
    }
}
