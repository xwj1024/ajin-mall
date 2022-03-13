package cn.leemay.mall.sys.auth.config;

import cn.leemay.mall.sys.system.service.Service;
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
    @Reference
    private Service service;

    @GetMapping
    public String a() {
        int a = service.a();
        System.err.println(a + "---");
        return "111---" + a;
    }
}
