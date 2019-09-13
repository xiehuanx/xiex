package xyz.xiex.security.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xiex.common.result.R;

/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/2
 * Time: 22:41
 * Describe:
 */
@FeignClient("xiexDemo")
public interface UserServiceFeign {

     @RequestMapping("/user/{loginname}")
     R selectUserByLoginName(@PathVariable("loginname") String loginname);
}
