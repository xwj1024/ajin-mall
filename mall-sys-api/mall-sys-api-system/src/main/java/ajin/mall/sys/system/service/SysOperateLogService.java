package ajin.mall.sys.system.service;

import ajin.mall.common.data.entity.system.SysOperateLog;

/**
 * @author Ajin
 */
public interface SysOperateLogService {
    /**
     * 添加系统操作日志
     *
     * @param sysOperateLog 添加对象
     */
    void add(SysOperateLog sysOperateLog);
}
