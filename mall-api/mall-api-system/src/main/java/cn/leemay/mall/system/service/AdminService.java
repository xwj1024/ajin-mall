package cn.leemay.mall.system.service;

import cn.leemay.mall.system.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 管理员表 服务类
 * </p>
 *
 * @author Ajin
 * @since 2021-05-07
 */
public interface AdminService extends IService<Admin> {
    /**
     * 添加管理员
     *
     * @param admin 管理员
     */
    void insert(Admin admin);
}
