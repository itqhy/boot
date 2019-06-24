package com.study.boot.common.auth.component;


import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.PatternMatchUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;

@Slf4j
@Component("pms")
public class PermissionService {


    /**
     * 判定是否有权访问
     * @param permission
     * @return
     */
    public boolean hasPermission(String permission) {
        if(StrUtil.isBlank(permission)){
            return false;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) {
            return false;
        }

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return authorities.parallelStream()
                .map(GrantedAuthority::getAuthority)
                .filter(StringUtils::hasText)
                .anyMatch(value-> PatternMatchUtils.simpleMatch(permission,value));
    }
}
