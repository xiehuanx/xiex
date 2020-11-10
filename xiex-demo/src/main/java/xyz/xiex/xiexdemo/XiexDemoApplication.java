package xyz.xiex.xiexdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class XiexDemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(XiexDemoApplication.class, args);
    }

}

