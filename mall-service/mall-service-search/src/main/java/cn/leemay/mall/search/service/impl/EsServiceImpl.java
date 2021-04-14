package cn.leemay.mall.search.service.impl;

import cn.leemay.mall.common.base.exception.SysException;
import cn.leemay.mall.search.es.EsEntity;
import cn.leemay.mall.search.es.EsMapping;
import cn.leemay.mall.search.service.EsService;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.AnalyzeRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

/**
 * @author Ajin
 * @create 2021/4/14
 */
public class EsServiceImpl implements EsService {

    // todo 学习autowired和resource 区别! 深入学习elasticsearch!
    // todo 学习日志!

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Override
    public void createIndex(String index, EsMapping mapping, int shards, int replicas) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(index);
        // 分词器
        AnalyzeRequest.CustomAnalyzerBuilder analyzerBuilder = AnalyzeRequest.buildCustomAnalyzer("ik_max_word");
        analyzerBuilder.build();
        request.settings(Settings.builder()
                // 分片数
                .put("index.number_of_shards", shards)
                // 副本数
                .put("index.number_of_replicas", replicas));
        // 指定mapping
        request.mapping("_doc", JSON.toJSONString(mapping), XContentType.JSON);
        CreateIndexResponse response = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        if (!response.isAcknowledged()) {
            throw new SysException("索引创建失败");
        }
    }

    @Override
    public void insertBatch(String index, List<EsEntity> list) throws IOException {
        BulkRequest request = new BulkRequest();
        list.forEach(item -> request.add(new IndexRequest(index).id(item.getId())
                .source(item.getJsonData(), XContentType.JSON)));
        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);

        if (response.hasFailures()) {
            throw new SysException(response.buildFailureMessage());
        }
    }

    @Override
    public void insertOrUpdate(String index, EsEntity entity) throws IOException {
        IndexRequest request = new IndexRequest(index);
        request.id(entity.getId());
        if (entity.getJsonData() == null) {
            request.source("{}", XContentType.JSON);
        } else {
            request.source(entity.getJsonData(), XContentType.JSON);
        }
        IndexResponse response = restHighLevelClient.index(request, RequestOptions.DEFAULT);

        if (response.status() != RestStatus.OK || response.status() != RestStatus.CREATED) {
            throw new SysException("添加或者更新失败");
        }
    }

    @Override
    public void delete(String index, String id) throws IOException {
        DeleteRequest request = new DeleteRequest(index, id);
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);

        if (response.status() != RestStatus.OK) {
            throw new SysException("删除失败");
        }
    }

}
