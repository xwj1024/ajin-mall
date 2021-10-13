package cn.leemay.mall.monitor.service;

/**
 * @author Ajin
 * @since 2021-8-11
 */
public interface  ServerInfoService {

    /**
     * 获取服务器硬件信息
     */
    void getHardwareInfo();

    /**
     * 获取操作系统信息
     */
    void getSystemInfo();

}
