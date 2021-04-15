package cn.leemay.mall.file.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author Ajin
 */
public interface UploadFileService {
    /**
     * 上传单个图片
     *
     * @param imgFile
     * @return
     * @throws IOException
     */
    String uploadImgFile(MultipartFile imgFile) throws IOException;

    /**
     * 上传多个图片
     *
     * @param imgFiles
     * @return
     * @throws IOException
     */
    List<String> uploadImgFiles(MultipartFile[] imgFiles) throws IOException;
}
