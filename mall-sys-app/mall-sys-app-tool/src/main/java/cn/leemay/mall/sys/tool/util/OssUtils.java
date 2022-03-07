package cn.leemay.mall.sys.tool.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.comm.ResponseMessage;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.util.List;

/**
 * @author Aliyun
 * @since 2021-04-13
 */
@Slf4j
public class OssUtils {
    public static void upload(String fileName, byte[] file, String domain, String bucket, String key, String secret) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，
        // 请登录 https://ram.console.aliyun.com 创建RAM账号。
        // String accessKeyId = "<yourAccessKeyId>";
        // String accessKeySecret = "<yourAccessKeySecret>";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(domain, key, secret);

        // 上传Byte数组。
        // PutObjectRequest putObjectRequest = new PutObjectRequest("<yourBucketName>", "<yourObjectName>", new ByteArrayInputStream(tool));
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket, fileName, new ByteArrayInputStream(file));

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        metadata.setObjectAcl(CannedAccessControlList.PublicRead);
        putObjectRequest.setMetadata(metadata);

        // 上传文件。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
        ResponseMessage response = putObjectResult.getResponse();
        String errorResponse = response.getErrorResponseAsString();
        log.error(errorResponse);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void delete(List<String> keys, String domain, String bucket, String key, String secret) {
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(domain, key, secret);

        // 删除文件。key等同于ObjectName，表示删除OSS文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。

        DeleteObjectsResult deleteObjectsResult = ossClient.deleteObjects(new DeleteObjectsRequest(bucket).withKeys(keys));
        ResponseMessage response = deleteObjectsResult.getResponse();
        String errorResponse = response.getErrorResponseAsString();
        log.error(errorResponse);
        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
