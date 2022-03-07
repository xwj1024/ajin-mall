package cn.leemay.mall.sys.tool.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Ajin
 * @since 2021-04-14
 */
public interface UploadFileService {
    /**
     * 上传单个图片
     *
     * @param imgFile 文件
     * @return 文件名
     * @throws IOException io异常
     */
    String uploadImgFile(MultipartFile imgFile) throws IOException;

    /**
     * 上传多个图片
     *
     * @param imgFiles 多个文件
     * @return 多个文件名
     * @throws IOException io异常
     */
    List<String> uploadImgFiles(MultipartFile[] imgFiles) throws IOException;
}
