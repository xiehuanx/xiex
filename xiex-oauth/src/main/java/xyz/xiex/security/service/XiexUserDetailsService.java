package xyz.xiex.security.service;

//import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.Component;
//import xyz.xiehuan.xiexdemo.entity.SysUser;
//import xyz.xiehuan.xiexdemo.service.ISysUserService;


/**
 * @author :xie xiehuan6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/2
 * Time: 16:31
 * Describe:
 */
@Component
@Slf4j
public class XiexUserDetailsService implements UserDetailsService {

    @Autowired
    private UserServiceFeign userServiceFeign;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("登陆用户："+username);
        boolean enabled=true;
        boolean accountNonExpired  =true;
        boolean credentialsNonExpired =true;
        boolean accountNonLocked =true;
/*       R<SysUser> r = userServiceFeign.selectUserByLoginName(username);
       SysUser data = r.getData();
        String userPassword = data.getUserPassword();*/
/*         if (r.getCode()==500){
            throw new XiexException("内部异常");
        }
        if (r.getData()==null){
            enabled=false;
        }
        if (data.get(0).getUserStatus().equals(UserContants.userStatus.FROZEN.getStatus())){
            accountNonLocked =false;
        }*/
        return new User(username,passwordEncoder.encode("123456"),
                enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }
}
