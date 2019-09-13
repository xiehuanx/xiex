package xyz.xiex.xiexdemo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xie
 * @since 2019-01-02
 */
@Data
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    private String loginName;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
    private String userNickname;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 历史密码
     */
    private String userPasswordHis;

    /**
     * 盐
     */
    private String userSalt;

    /**
     * Email
     */
    private String userEmail;

    /**
     * 电话
     */
    private String userPhone;

    /**
     * address
     */
    private String userAddress;

    /**
     *  0 删除；1 正常；2 冻结；
     */
    private String userStatus;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;


    @Override
    public String toString() {
        return "SysUser{" +
        "userId=" + userId +
        ", userName=" + userName +
        ", userNickname=" + userNickname +
        ", userPassword=" + userPassword +
        ", userPasswordHis=" + userPasswordHis +
        ", userSalt=" + userSalt +
        ", userEmail=" + userEmail +
        ", userPhone=" + userPhone +
        ", userAddress=" + userAddress +
        ", userStatus=" + userStatus +
        "}";
    }
}
