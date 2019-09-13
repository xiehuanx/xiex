package xyz.xiex.security.properties;

import lombok.Data;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2019/9/9
 * Time: 10:10
 * Describe: ClientDetailsServiceConfigurer
 */
@Data
public class ClientDetailsServiceConfigProperties {

    private String clientId="xiex";

    private String resourceIds="xiexResourceIds";

    private String authorizedGrantTypes="password,authorization_code,refresh_token";

    private int accessTokenValiditySeconds=7200;

    private int refreshTokenValiditySeconds=7200;

    private String registeredRedirectUri;

    private String ClientSecret="{noop}123456";

    private String scope="ALL";

}
