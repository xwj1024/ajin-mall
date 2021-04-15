package cn.leemay.mall.file.service.impl;

import cn.leemay.mall.common.base.exception.BusException;
import cn.leemay.mall.common.base.util.DateTimeUtils;
import cn.leemay.mall.file.property.OssProperties;
import cn.leemay.mall.file.service.UploadFileService;
import cn.leemay.mall.file.util.OssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Ajin
 * @create 2021/4/13
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

    // todo 将图片存入redis把多余图片用定时任务进行删除,redis中的key也要加入定时任务,设置过期时间
    //  学习redis使用注解怎么配置!深入学习redis原理

    @Autowired
    private OssProperties ossProperties;

    @Override
    public String uploadImgFile(MultipartFile imgFile) throws IOException {
        // 获取源文件名
        String originalFilename = imgFile.getOriginalFilename();
        // 判断文件是否为空
        if (originalFilename == null) {
            throw new BusException("文件错误");
        }
        String folderFileName = saveFile(imgFile, originalFilename);
        return ossProperties.getUrl() + folderFileName;
    }

    @Override
    public List<String> uploadImgFiles(MultipartFile[] imgFiles) throws IOException {
        List<String> folderFileNameList = new ArrayList<>();
        for (MultipartFile imgFile : imgFiles) {
            if (imgFile != null && !imgFile.isEmpty() && imgFile.getOriginalFilename() != null) {
                String originalFilename = imgFile.getOriginalFilename();
                String folderFileName = saveFile(imgFile, originalFilename);
                folderFileNameList.add(ossProperties.getUrl() + folderFileName);
            }
        }
        return folderFileNameList;
    }

    private String saveFile(MultipartFile imgFile, String originalFilename) throws IOException {
        int index = originalFilename.lastIndexOf(".");
        // 获取原文件扩展名
        String extension = originalFilename.substring(index - 1);
        // 随机生成新文件名
        String fileName = UUID.randomUUID().toString() + extension;
        // 获取文件字节数组
        byte[] bytes = imgFile.getBytes();
        // 根据日期设置文件夹名称
        String date = DateTimeUtils.formatDate(new Date());
        String folderFileName = date + "/" + fileName;
        // 将文件上传到云服务器
        OssUtils.upload(folderFileName, bytes, ossProperties.getDomain(), ossProperties.getBucket(),
                ossProperties.getKey(), ossProperties.getSecret());
        return folderFileName;
    }

}
