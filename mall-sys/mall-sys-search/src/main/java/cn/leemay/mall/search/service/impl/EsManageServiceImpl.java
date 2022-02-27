package cn.leemay.mall.search.service.impl;

import cn.leemay.mall.search.entity.GoodsInfo;
import cn.leemay.mall.search.es.EsMapping;
import cn.leemay.mall.search.property.EsProperties;
import cn.leemay.mall.search.service.EsManageService;
import cn.leemay.mall.search.service.EsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Ajin
 * @since 2021-04-20
 */
@Service
public class EsManageServiceImpl implements EsManageService {

    @Autowired
    private EsService esService;

    @Autowired
    private EsProperties esProperties;

    @Override
    public void createIndex() throws IOException {
        esService.createIndex(esProperties.getIndex(),
                EsMapping.byType(true, GoodsInfo.class),
                esProperties.getShards(),esProperties.getReplicas());
    }

    @Override
    public void importBatch() {

    }
}
