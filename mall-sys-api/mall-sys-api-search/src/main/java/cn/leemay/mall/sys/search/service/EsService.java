package cn.leemay.mall.sys.search.service;

import cn.leemay.mall.sys.search.es.EsEntity;
import cn.leemay.mall.sys.search.es.EsMapping;

import java.io.IOException;
import java.util.List;

/**
 * 封装ES通用API
 *
 * @author Ajin
 * @since 2021-04-14
 */
public interface EsService {

    /**
     * 创建索引
     *
     * @param index    索引名称
     * @param mapping  索引描述
     * @param shards   分片数
     * @param replicas 副本数
     * @throws IOException 异常
     */
    void createIndex(String index, EsMapping mapping, int shards, int replicas) throws IOException;

    /**
     * 批量插入数据
     *
     * @param index index
     * @param list  插入列表
     * @throws Exception 异常
     */
    void insertBatch(String index, List<EsEntity> list) throws Exception;

    /**
     * 插入或更新单条记录
     *
     * @param index  索引
     * @param entity 对象
     * @throws Exception 异常
     */
    void insertOrUpdate(String index, EsEntity entity) throws Exception;

    /**
     * 删除单条记录
     *
     * @param index 索引
     * @param id    id
     * @throws IOException 异常
     */
    void delete(String index, String id) throws IOException;

}
