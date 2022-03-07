package cn.leemay.mall.sys.monitor.service;

import cn.leemay.mall.monitor.entity.ServerInfo;

/**
 * @author Ajin
 * @since 2021-8-11
 */
public interface ServerInfoService {

    /**
     * 获取服务器信息
     *
     * @return 服务器信息
     */
    ServerInfo getServerInfo();

}
