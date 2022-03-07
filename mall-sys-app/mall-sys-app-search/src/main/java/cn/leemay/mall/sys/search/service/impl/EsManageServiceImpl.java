package cn.leemay.mall.sys.search.service.impl;

import cn.leemay.mall.sys.search.index.GoodsIndex;
import cn.leemay.mall.sys.search.es.EsMapping;
import cn.leemay.mall.sys.search.property.EsProperties;
import cn.leemay.mall.sys.search.service.EsManageService;
import cn.leemay.mall.sys.search.service.EsService;
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
                EsMapping.byType(true, GoodsIndex.class),
                esProperties.getShards(),esProperties.getReplicas());
    }

    @Override
    public void importBatch() {

    }
}
