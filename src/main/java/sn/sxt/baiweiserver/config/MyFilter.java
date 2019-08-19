package sn.sxt.baiweiserver.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import sn.sxt.baiweiserver.bean.Menu;
import sn.sxt.baiweiserver.bean.Role;
import sn.sxt.baiweiserver.service.MenuService;

import java.util.Collection;
import java.util.List;

/**
 * @Author 江南一点雨
 * @Site www.javaboy.org 2019-07-18 16:35
 * <p>
 * 在这个类中，分析用户请求的 URL 地址需要哪些角色
 */
@Component
public class MyFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 请求参数可以提取出当前请求的 URL 地址
     *
     * @param object
     * @return 返回值就是当前请求路径所需要的角色
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        System.out.println("myFilter");
        String requestUrl = ((FilterInvocation) object).getRequestUrl();//这个就是用户的请求路径
        List<Menu> allMenus = menuService.getAllMenus();
        for (Menu menu : allMenus){
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                List<Role> roles = menu.getRoles();

                String[] rolesStr = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    rolesStr[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(rolesStr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
