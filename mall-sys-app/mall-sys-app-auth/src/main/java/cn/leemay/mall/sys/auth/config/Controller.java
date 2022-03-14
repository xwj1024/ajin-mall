package cn.leemay.mall.sys.auth.config;

import cn.leemay.mall.common.base.constant.DubboConstants;
import cn.leemay.mall.common.data.entity.system.SysUser;
import cn.leemay.mall.sys.system.service.Service;
import cn.leemay.mall.sys.system.service.SysUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ajin
 * @since 2022-3-14
 */
@RestController
@RequestMapping("/a")
public class Controller {
    @Reference(group = DubboConstants.GROUP, check = false)
    private Service service;
    @Reference(group = DubboConstants.GROUP, check = false)
    private SysUserService sysUserService;

    @GetMapping
    public String a() {
        int     a    = service.a();
        SysUser root = sysUserService.loadUserByUsername("root");
        System.err.println(root);
        System.err.println("===========");
        System.err.println(a);
        return "ok---";
    }
}
