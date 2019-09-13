package xyz.xiex.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.xiex.common.result.R;

/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/25
 * Time: 14:51
 * Describe:
 */
@FeignClient("xiexDemo")
public interface DemoFeignService {
    /**
     * 根据登陆账号查询用户信息
     * @param loginname
     * @return
     */
    @RequestMapping("/user/{loginname}")
    R selectUserByLoginName(@PathVariable("loginname") String loginname);
}
