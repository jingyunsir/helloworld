package com.lisir.demo.springboot_jpa.repostory;

import com.lisir.demo.springboot_jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReporstory extends JpaRepository<User,Long>{

    User findAllByNameEqualsAndPasswordEquals(String username,String password);
}
