package xyz.xiex.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.resource.spi.SecurityPermission;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :xie xiehuan6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/17
 * Time: 20:39
 * Describe:
 */
@RestController
public class test {

    String sds="ds";

    ArrayList<String> stringArrayList=new ArrayList<>();
    public void demo(){
        List<String> stringList = stringArrayList.subList(1, 2);
    }

    @RequestMapping("/test")
    public Object string(){

        return "test ";
    }

    @GetMapping("/authentication")
    @PreAuthorize("")
    public Object authentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
