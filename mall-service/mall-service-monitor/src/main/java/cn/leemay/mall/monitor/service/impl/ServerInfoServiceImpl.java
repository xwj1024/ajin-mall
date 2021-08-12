package cn.leemay.mall.monitor.service.impl;

import cn.leemay.mall.monitor.service.ServerInfoService;
import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

/**
 * @author Ajin
 * @since 2021-8-12
 */
public class ServerInfoServiceImpl implements ServerInfoService {

    @Override
    public void getHardwareInfo() {
        SystemInfo systemInfo = new SystemInfo();
        HardwareAbstractionLayer hardware = systemInfo.getHardware();
        // todo
    }

    @Override
    public void getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        // todo
    }
}
