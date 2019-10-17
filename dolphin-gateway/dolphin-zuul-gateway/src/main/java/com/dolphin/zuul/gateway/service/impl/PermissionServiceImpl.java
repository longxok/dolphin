package com.dolphin.zuul.gateway.service.impl;

import com.dolphin.common.model.SysMenu;
import com.dolphin.oauth2.common.service.impl.DefaultPermissionServiceImpl;
import com.dolphin.zuul.gateway.feign.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 请求权限判断service
 *
 * @author dolphin
 * @date 2018/10/28
 */
@Slf4j
@Service("permissionService")
public class PermissionServiceImpl extends DefaultPermissionServiceImpl {
    @Resource
    private MenuService menuService;

    @Override
    public List<SysMenu> findMenuByRoleCodes(String roleCodes) {
        return menuService.findByRoleCodes(roleCodes);
    }
}
