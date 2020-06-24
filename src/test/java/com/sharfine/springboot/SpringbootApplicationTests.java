package com.sharfine.springboot;

import com.sharfine.springboot.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

    @Autowired
    private UserDao userDao;

        @Test
    void aaaa() {

        System.out.println( userDao.getUserById(1).toString());
    }
    @Test
    void aaaaa() {

        userDao.insert("哈哈哈25",25);
    }

}
