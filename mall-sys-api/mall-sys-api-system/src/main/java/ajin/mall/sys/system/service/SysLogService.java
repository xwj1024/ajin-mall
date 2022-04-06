package ajin.mall.sys.system.service;

import ajin.mall.common.data.entity.system.SysLog;

/**
 * @author Ajin
 */
public interface SysLogService {
    /**
     * 添加系统操作日志
     *
     * @param sysLog 添加对象
     */
    void add(SysLog sysLog);
}
