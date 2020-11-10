package xyz.xiex.security.config;

import cn.hutool.core.util.ArrayUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import xyz.xiex.security.properties.AuthoriaztionServerConfigProperties;
import xyz.xiex.security.properties.ClientDetailsServiceConfigProperties;
import xyz.xiex.security.service.XiexUserDetailsService;

import javax.sql.DataSource;


/**
 * @author :xie xiex6027023673
 * Email: 1487471733@qq.com
 * Date: 2019/1/6
 * Time: 13:21
 * Describe:
 */
@Configuration
@EnableAuthorizationServer
@EnableResourceServer
@Slf4j
public class XiexAuthoriaztionServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private XiexUserDetailsService userDetailsService;

    @Autowired
    private RedisConnectionFactory connectionFactory;
    @Autowired(required = false)
    private AuthoriaztionServerConfigProperties authoriaztionServerConfigProperties;
    @Autowired
    private DataSource dataSource;
    @Autowired(required = false)
    HttpSecurity http;



    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }

    /**
     * 注册clients到授权服务器
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
/*        ClientDetailsServiceConfigProperties[] clientsProperties = authoriaztionServerConfigProperties.getClients();
        //注册到内存中
        InMemoryClientDetailsServiceBuilder builder = clients.inMemory();
        if (!ArrayUtil.isEmpty(clientsProperties)) {
            for (int i = 0; i < clientsProperties.length; i++) {
                builder.withClient(clientsProperties[i].getClientId())
                        .resourceIds(clientsProperties[i].getResourceIds())
                        .secret(clientsProperties[i].getClientSecret())
                        .authorizedGrantTypes(clientsProperties[i].getAuthorizedGrantTypes().split(","))
                        .refreshTokenValiditySeconds(clientsProperties[i].getRefreshTokenValiditySeconds())
                        .accessTokenValiditySeconds(clientsProperties[i].getAccessTokenValiditySeconds())
                        .scopes(clientsProperties[i].getScope().split(","));
            }
        }*/
       clients.jdbc(dataSource).clients(jdbcClientDetailsService());
    }

    /**
     * 配置授权 Token 的节点和 Token 服务
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 身份认证管理器, 主要用于"password"授权模式
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                //.tokenStore(tokenServices());
                .tokenServices(tokenServices());
    }

    /**
     * https://stackoverflow.com/questions/26750999/spring-security-oauth2-check-token-endpoint
     * https://stackoverflow.com/questions/26250522/how-to-use-remotetokenservice
     * 暴露permitAll
     *
     * @param oauthServer
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .checkTokenAccess("permitAll()")//.init(http)
        ;
    }

    @Bean
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(redisTokenStore());
        //defaultTokenServices.setRefreshTokenValiditySeconds(200);
        //defaultTokenServices.setAccessTokenValiditySeconds(200);
        return defaultTokenServices;
    }

    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore redis = new RedisTokenStore(connectionFactory);
        return redis;
    }
}
