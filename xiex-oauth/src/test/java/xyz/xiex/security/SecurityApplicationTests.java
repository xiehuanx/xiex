package xyz.xiex.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.xiex.common.utils.PasswordSaltUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SecurityApplicationTests {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final static String passwordSalt="xiehuanx";

    @Test
    public void contextLoads() {
        String password="123456";
        String  salt = PasswordSaltUtil.randomSalt();
        String encode = passwordEncoder.encode(password+salt);
        System.out.println("passwprd:"+encode);
        System.out.println("salt:"+salt);
        boolean matches = passwordEncoder.matches(password+salt, encode);
        System.out.println(matches);
    }
    @Test
    public void demo1(){

        for (int i=0;i<passwordSalt.length();i++){
            System.out.println(passwordSalt.charAt(i));
        }
    }

}

