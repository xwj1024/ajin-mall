package ajin.mall.sys.system.service.impl;

import ajin.mall.common.data.entity.SysLog;
import ajin.mall.sys.system.mapper.SysLogMapper;
import ajin.mall.sys.system.service.SysLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author A
 */
@org.apache.dubbo.config.annotation.Service
@Service
public class SysLogServiceImpl implements SysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void add(SysLog sysLog) {
        sysLogMapper.insert(sysLog);
    }
}
