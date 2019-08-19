package sn.sxt.baiweiserver.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-18 16:59
 */
@Component
public class MyDecision implements AccessDecisionManager {
    /**
     * 这个方法用来判断当前用户是否具备请求所i需要的角色，如果不具备，直接在方法中抛出异常，如果具备，什么事情都不做
     *
     * @param authentication
     * @param object
     * @param configAttributes
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        System.out.println("MyDecision");
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();//获取当前用户角色
        for (ConfigAttribute configAttribute : configAttributes) {
            String attribute = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(attribute)) {
                if (authentication instanceof UsernamePasswordAuthenticationToken) {
                    //说明当前用户已登录，放行
                    return;
                } else {
                    throw new AccessDeniedException("权限不足");
                }
            }
            for (GrantedAuthority authority : authorities) {
                if (authority.getAuthority().equals(attribute)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
