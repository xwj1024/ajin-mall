package ajin.mall.web.system.service.impl;

import ajin.mall.common.data.entity.BizLog;
import ajin.mall.web.system.mapper.BizLogMapper;
import ajin.mall.web.system.service.BizLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 商务日志服务impl
 *
 * @author Ajin
 * @date 2022/04/15
 */
@Service
@org.apache.dubbo.config.annotation.Service
public class BizLogServiceImpl implements BizLogService {

    @Resource
    private BizLogMapper bizLogMapper;

    @Override
    public void add(BizLog bizLog) {
        bizLogMapper.insert(bizLog);
    }
}
