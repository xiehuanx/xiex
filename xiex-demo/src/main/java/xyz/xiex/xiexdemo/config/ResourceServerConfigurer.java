package xyz.xiex.xiexdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/18
 * Time: 22:07
 * Describe:
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

  /*  @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;*/

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http//.exceptionHandling()
                // 定义的不存在access_token时候响应
                //.authenticationEntryPoint(authenticationEntryPointConfig)
                //.and()
                .authorizeRequests()
                .antMatchers("/actuator/**", "/au", "/myHello", "/sys/user/hello/test", "/test/role").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .resourceId("123456")
                .tokenServices(tokenServices());
        //resources.authenticationEntryPoint(authenticationEntryPoint);
    }

    /**
     * 2019/01/31 验证token 忘记配置进resources中，导致报错（.tokenServices(tokenServices())）
     * @return
     */
    @Bean
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices remoteTokenServices = new DefaultTokenServices();
        remoteTokenServices.setTokenStore(redisTokenStore());
        return remoteTokenServices;
    }

    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        return tokenStore;
    }
}
