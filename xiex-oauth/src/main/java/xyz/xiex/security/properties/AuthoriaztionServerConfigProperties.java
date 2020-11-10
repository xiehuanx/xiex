package xyz.xiex.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2019/9/9
 * Time: 10:09
 * Describe:
 */
@Data
//@ConfigurationProperties(prefix = "xyz.xiex.security.oauth")
//@Configuration
public class AuthoriaztionServerConfigProperties {

    private String saveClientDetailsServiceType="memory";
    private ClientDetailsServiceConfigProperties[] clients={};
}
