package ajin.mall.web.system.service;

import ajin.mall.common.data.entity.BizLog;

/**
 * 商务日志服务
 *
 * @author Ajin
 * @date 2022/04/15
 */
public interface BizLogService {

    /**
     * 添加
     *
     * @param bizLog 商务日志
     */
    void add(BizLog bizLog);
}
