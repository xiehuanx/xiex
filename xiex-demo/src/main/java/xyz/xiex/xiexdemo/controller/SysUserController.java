package xyz.xiex.xiexdemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import xyz.xiex.common.result.R;
import xyz.xiex.xiexdemo.entity.SysUser;
import xyz.xiex.xiexdemo.service.ISysUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xie
 * @since 2019-01-02
 */
@Controller
public class SysUserController {

    @Autowired
    private ISysUserService sysUserService;

/*    private RequestCache requsetCache=new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();*/

    @RequestMapping("/test")
    @ResponseBody
    public String demo(){
        return "test";
    }
    @RequestMapping("/authentication/require")
    @ResponseBody
    public R renzhen(HttpServletRequest request, HttpServletResponse response) throws IOException {
/*        SavedRequest savedRequest=requsetCache.getRequest(request,response);
        if (savedRequest!=null){
            String url=savedRequest.getRedirectUrl();
            if (StrUtil.endWith(url,".html")){
                redirectStrategy.sendRedirect(request,response,"/login.html");
            }else{
                redirectStrategy.sendRedirect(request,response,"/login.html");
            }
        }*/
        return R.error("错误");
    }

    @RequestMapping( value = "/user/{loginname}",method= RequestMethod.GET)
    @ResponseBody
    public R selectUserByLoginName(@PathVariable("loginname") String loginname){
        List<SysUser> sysUsers = sysUserService.list(new LambdaQueryWrapper<SysUser>().eq(SysUser::getLoginName, loginname));
        //loginname 必须具有不可重复性
        if (sysUsers.size()>1){
          return   R.error("loginname不可以重复");
        }else{
            return R.success(sysUsers);
        }

    }

    @GetMapping("/userinfo·1·")
    @ResponseBody
    public Object authentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
