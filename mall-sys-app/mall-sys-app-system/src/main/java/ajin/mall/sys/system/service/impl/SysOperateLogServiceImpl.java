package ajin.mall.sys.system.service.impl;

import ajin.mall.common.data.entity.system.SysOperateLog;
import ajin.mall.sys.system.mapper.SysOperateLogMapper;
import ajin.mall.sys.system.service.SysOperateLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author A
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class SysOperateLogServiceImpl implements SysOperateLogService {

    @Resource
    private SysOperateLogMapper sysOperateLogMapper;

    @Override
    public void add(SysOperateLog sysOperateLog) {
        sysOperateLogMapper.insert(sysOperateLog);
    }
}
