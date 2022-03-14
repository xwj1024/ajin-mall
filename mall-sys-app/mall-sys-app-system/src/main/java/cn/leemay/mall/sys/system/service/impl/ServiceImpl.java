package cn.leemay.mall.sys.system.service.impl;

import cn.leemay.mall.common.base.constant.DubboConstants;
import cn.leemay.mall.sys.system.service.Service;

/**
 * @author Ajin
 * @since 2022-3-14
 */
@org.apache.dubbo.config.annotation.Service(group = DubboConstants.GROUP)
public class ServiceImpl implements Service {

    @Override
    public int a() {
        return 100;
    }
}
