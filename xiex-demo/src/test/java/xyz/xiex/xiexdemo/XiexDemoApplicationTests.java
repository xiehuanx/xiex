package xyz.xiex.xiexdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.xiex.xiexdemo.service.ISysUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class XiexDemoApplicationTests {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void contextLoads() {

        stringRedisTemplate.opsForValue().set("12","1212");
        System.out.println(stringRedisTemplate.opsForValue().get("12"));


        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);


        String str3 = "计算机" + "软件";
        System.out.println(str3.intern() == str3);
        String str4 = "ja" +"va";
        System.out.println(str4.intern() == str4);


     }



}

