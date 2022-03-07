package cn.leemay.mall.sys.search.service;

import java.io.IOException;

/**
 * @author Ajin
 * @since 2021-04-20
 */
public interface EsManageService {
    /**
     * 创建索引
     *
     * @throws IOException 异常
     */
    void createIndex() throws IOException;

    /**
     * 批量导入
     */
    void importBatch();

}
