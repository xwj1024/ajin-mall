package cn.leemay.mall.search.service;

import java.io.IOException;

/**
 * @author Ajin
 * @create 2021/4/20
 */
public interface EsManageService {
    /**
     * 创建索引
     */
    void createIndex() throws IOException;

    /**
     * 批量导入
     */
    void importBatch();

}
