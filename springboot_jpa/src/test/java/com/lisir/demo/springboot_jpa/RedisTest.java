package com.lisir.demo.springboot_jpa;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisir.demo.springboot_jpa.domain.User;
import com.lisir.demo.springboot_jpa.repostory.UserReporstory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootJpaApplication.class)
public class RedisTest {

    @Autowired
    private UserReporstory userReporstory;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Test
    public void test() throws JsonProcessingException {
        //1.查询用户
        String login = redisTemplate.boundValueOps("loginUser").get();
        //2.判断用户是否为空
        if(null == login){
            //3.若为空则从数据库中查询 并添加到redis
            User user = userReporstory.findAllByNameEqualsAndPasswordEquals("admin", "admin");
            ObjectMapper om = new ObjectMapper();
            login = om.writeValueAsString(user);
            redisTemplate.boundValueOps("loginUser").set(login);
            System.out.println("从数据库中查询");
        }else {
            System.out.println("===========");
        }
        //4.不为空则从redis中查询
        System.out.println(login);
    }
}
