package com.chinasoft;

import com.chinasoft.data.entity.User;
import com.chinasoft.data.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by VerRan.Liu on 2017/11/17.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    UserRepository userRepository ;
    @Test
    public void add(){//用户

        //1. 创建用户
        User user =new User();
        user.setName("lht");
        user.setMobilePhone("15319746639");
        user =userRepository.save(user);
        Assert.assertEquals("lht",user.getName());
    }
}
