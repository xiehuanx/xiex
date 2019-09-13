package xyz.xiex.xiexdemo.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xyz.xiex.xiexdemo.entity.SysUser;
import xyz.xiex.xiexdemo.mapper.SysUserMapper;
import xyz.xiex.xiexdemo.service.ISysUserService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xie
 * @since 2019-01-02
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}
