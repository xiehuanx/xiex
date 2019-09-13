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


     }



}

