package cn.leemay.mall.sys.monitor.service.impl;

import cn.leemay.mall.common.base.util.ArithmeticUtils;
import cn.leemay.mall.common.base.util.ByteConvertUtils;
import cn.leemay.mall.common.base.util.DateTimeUtils;
import cn.leemay.mall.common.base.util.IpUtils;
import cn.leemay.mall.sys.monitor.entity.*;
import cn.leemay.mall.sys.monitor.service.ServerInfoService;
import org.springframework.stereotype.Service;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.util.Util;

import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

/**
 * @author Ajin
 * @since 2021-8-12
 */
@Service
public class ServerInfoServiceImpl implements ServerInfoService {

    @Override
    public ServerInfo getServerInfo() {
        SystemInfo systemInfo = new SystemInfo();
        ServerInfo serverInfo = new ServerInfo();
        OperatingSystem          operatingSystem = systemInfo.getOperatingSystem();
        HardwareAbstractionLayer hardware        = systemInfo.getHardware();
        List<DiskInfo>           diskInfoList    = setDiskInfo(operatingSystem.getFileSystem());
        CpuInfo                  cpuInfo         = setCpuInfo(hardware.getProcessor());
        MemInfo                  memInfo         = setMemInfo(hardware.getMemory());
        SysInfo                  sysInfo         = setSysInfo();
        JvmInfo                  jvmInfo         = setJvmInfo();
        serverInfo.setDiskInfoList(diskInfoList);
        serverInfo.setCpuInfo(cpuInfo);
        serverInfo.setMemInfo(memInfo);
        serverInfo.setSysInfo(sysInfo);
        serverInfo.setJvmInfo(jvmInfo);
        return serverInfo;
    }

    /**
     * 设置磁盘信息
     *
     * @param fileSystem 文件系统
     * @return 磁盘信息
     */
    private List<DiskInfo> setDiskInfo(FileSystem fileSystem) {
        List<OSFileStore> fileStores   = fileSystem.getFileStores();
        List<DiskInfo>    diskInfoList = new LinkedList<>();
        for (OSFileStore fileStore : fileStores) {
            long     total    = fileStore.getTotalSpace();
            long     free     = fileStore.getUsableSpace();
            long     used     = total - free;
            DiskInfo diskInfo = new DiskInfo();
            diskInfo.setDirName(fileStore.getMount());
            diskInfo.setDirType(fileStore.getType());
            diskInfo.setFileType(fileStore.getName());
            diskInfo.setTotal(ByteConvertUtils.convertFileSize(total));
            diskInfo.setFree(ByteConvertUtils.convertFileSize(free));
            diskInfo.setUsed(ByteConvertUtils.convertFileSize(used));
            diskInfo.setUsage(ArithmeticUtils.mul(ArithmeticUtils.div(used, total, 4), 100));
            diskInfoList.add(diskInfo);
        }
        return diskInfoList;
    }

    /**
     * 设置CPU信息
     *
     * @param processor 处理器
     * @return cpu信息
     */
    private CpuInfo setCpuInfo(CentralProcessor processor) {
        long[] prevTicks = processor.getSystemCpuLoadTicks();
        Util.sleep(ServerInfo.OSHI_WAIT);
        long[]  ticks    = processor.getSystemCpuLoadTicks();
        long    nice     = ticks[TickType.NICE.getIndex()] - prevTicks[TickType.NICE.getIndex()];
        long    irq      = ticks[TickType.IRQ.getIndex()] - prevTicks[TickType.IRQ.getIndex()];
        long    softirq  = ticks[TickType.SOFTIRQ.getIndex()] - prevTicks[TickType.SOFTIRQ.getIndex()];
        long    steal    = ticks[TickType.STEAL.getIndex()] - prevTicks[TickType.STEAL.getIndex()];
        long    cSys     = ticks[TickType.SYSTEM.getIndex()] - prevTicks[TickType.SYSTEM.getIndex()];
        long    user     = ticks[TickType.USER.getIndex()] - prevTicks[TickType.USER.getIndex()];
        long    iowait   = ticks[TickType.IOWAIT.getIndex()] - prevTicks[TickType.IOWAIT.getIndex()];
        long    idle     = ticks[TickType.IDLE.getIndex()] - prevTicks[TickType.IDLE.getIndex()];
        long    totalCpu = user + nice + cSys + idle + iowait + irq + softirq + steal;
        CpuInfo cpuInfo  = new CpuInfo();
        cpuInfo.setCpuNum(processor.getLogicalProcessorCount());
        cpuInfo.setTotalRate(totalCpu);
        cpuInfo.setSysRate(cSys);
        cpuInfo.setUsedRate(user);
        cpuInfo.setWaitRate(iowait);
        cpuInfo.setFreeRate(idle);
        return cpuInfo;
    }

    /**
     * 设置内存信息
     *
     * @param memory 内存
     * @return 内存信息
     */
    private MemInfo setMemInfo(GlobalMemory memory) {
        MemInfo memInfo = new MemInfo();
        memInfo.setTotal(memory.getTotal());
        memInfo.setUsed(memory.getTotal() - memory.getAvailable());
        memInfo.setFree(memory.getAvailable());
        return memInfo;
    }

    /**
     * 设置系统信息
     *
     * @return 系统信息
     */
    private SysInfo setSysInfo() {
        Properties properties = System.getProperties();
        SysInfo    sysInfo    = new SysInfo();
        sysInfo.setComputerName(IpUtils.getHostName());
        sysInfo.setComputerIp(IpUtils.getHostName());
        sysInfo.setOsName(properties.getProperty("os.name"));
        sysInfo.setOsArch(properties.getProperty("os.arch"));
        sysInfo.setOsVersion(properties.getProperty("os.version"));
        return sysInfo;
    }

    /**
     * 设置jvm信息
     *
     * @return jvm信息
     */
    private JvmInfo setJvmInfo() {
        Properties properties = System.getProperties();
        JvmInfo    jvmInfo    = new JvmInfo();
        jvmInfo.setTotalMemory(Runtime.getRuntime().totalMemory());
        jvmInfo.setMaxMemory(Runtime.getRuntime().maxMemory());
        jvmInfo.setFreeMemory(Runtime.getRuntime().freeMemory());
        jvmInfo.setVersion(properties.getProperty("java.version"));
        jvmInfo.setHome(properties.getProperty("java.home"));
        jvmInfo.setName(properties.getProperty("java.vm.name"));
        jvmInfo.setStartTime(DateTimeUtils.parseDateToStr(DateTimeUtils.DATETIME_FORMAT, DateTimeUtils.getServerStartDate()));
        jvmInfo.setRunTime(DateTimeUtils.getDatePoor(DateTimeUtils.getNowDate(), DateTimeUtils.getServerStartDate()));
        return jvmInfo;
    }
}
