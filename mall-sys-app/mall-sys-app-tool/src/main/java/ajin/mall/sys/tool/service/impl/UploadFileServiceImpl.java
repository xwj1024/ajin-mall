package ajin.mall.sys.tool.service.impl;

import ajin.mall.common.base.exception.BizException;
import ajin.mall.common.base.util.DateTimeUtils;
import ajin.mall.sys.tool.property.OssProperties;
import ajin.mall.sys.tool.service.UploadFileService;
import ajin.mall.sys.tool.util.OssUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author Ajin
 * @since 2021-04-13
 */
@Service
public class UploadFileServiceImpl implements UploadFileService {

    @Resource
    private OssProperties ossProperties;

    @Override
    public String uploadImgFile(MultipartFile imgFile) throws IOException {
        // 获取源文件名
        String originalFilename = imgFile.getOriginalFilename();
        // 判断文件是否为空
        if (originalFilename == null) {
            throw new BizException("文件错误");
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
        String extension = originalFilename.substring(index);
        // 随机生成新文件名
        String fileName = UUID.randomUUID() + extension;
        // 获取文件字节数组
        byte[] bytes = imgFile.getBytes();
        // 根据日期设置文件夹名称
        String date = DateTimeUtils.formatDate2Str(new Date());
        String folderFileName = date + "/" + fileName;
        // 将文件上传到云服务器
        OssUtils.upload(folderFileName, bytes, ossProperties.getDomain(), ossProperties.getBucket(),
                ossProperties.getKey(), ossProperties.getSecret());
        return folderFileName;
    }

}
