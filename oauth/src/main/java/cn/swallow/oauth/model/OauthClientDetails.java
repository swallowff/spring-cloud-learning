package cn.swallow.oauth.model;

import cn.swallow.oauth.common.constant.CommonDbStringDefine;
import cn.swallow.oauth.common.jpa.JpaCustomSnowIdBaseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author shenyu
 * @create 2019/11/9
 */
@Entity
@Table(name = "sys_role")
@Deprecated
public class OauthClientDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "snow-id")   //使用自定义ID生成策略
    @GenericGenerator(name = "snow-id", strategy = "cn.swallow.oauth.common.util.JpaCustomIDgenerator")
    private String clientId;
    @Column
    private String resourceIds;
    @Column
    private String clientSecret;
    @Column
    private String scope;
    @Column
    private String authorizedGrantTypes;
    @Column
    private String webServerRedirectUri;
    @Column
    private String authorities;
    @Column
    private Integer accessTokenValidity;
    @Column
    private Integer refreshTokenValidity;
    @Column
    private String additionalInformation;
    @Column
    private String autoapprove;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getAuthorizedGrantTypes() {
        return authorizedGrantTypes;
    }

    public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
        this.authorizedGrantTypes = authorizedGrantTypes;
    }

    public String getWebServerRedirectUri() {
        return webServerRedirectUri;
    }

    public void setWebServerRedirectUri(String webServerRedirectUri) {
        this.webServerRedirectUri = webServerRedirectUri;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
