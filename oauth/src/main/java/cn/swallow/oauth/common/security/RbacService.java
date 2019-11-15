package cn.swallow.oauth.common.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

@Deprecated
public interface RbacService {
    boolean hasPermission(HttpServletRequest request, Authentication authentication);

}
