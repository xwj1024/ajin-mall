package cn.leemay.mall.sys.tool.controller;

import cn.leemay.mall.common.base.result.BaseResult;
import cn.leemay.mall.common.base.result.ResultCode;
import cn.leemay.mall.sys.tool.service.UploadFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * @author Ajin
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/tool/uploadFile")
@Api(tags = "文件上传")
@CrossOrigin
public class UploadFileController {

    @Resource
    private UploadFileService uploadFileService;

    @PostMapping(value = "/uploadImgFile", headers = "content-type=multipart/form-data")
    @ApiOperation("上传单个图片")
    public BaseResult<String> uploadImgFile(@RequestParam("imgFile") MultipartFile imgFile) throws IOException {
        if (imgFile == null || imgFile.getSize() <= 0 || imgFile.isEmpty()) {
            return new BaseResult<>(ResultCode.ERR, "无图片上传");
        }
        // 上传图片
        String fileName = uploadFileService.uploadImgFile(imgFile);
        return new BaseResult<>(ResultCode.OK, "上传成功", fileName);
    }

    @PostMapping(value = "/uploadImgFiles", headers = "content-type=multipart/form-data")
    @ApiOperation("上传多张图片")
    public BaseResult<List<String>> uploadImgFiles(@RequestParam("imgFiles") MultipartFile[] imgFiles) throws IOException {
        if (imgFiles == null || imgFiles.length <= 0) {
            return new BaseResult<>(ResultCode.ERR, "无图片上传");
        }
        // 上传图片
        List<String> fileNameList = uploadFileService.uploadImgFiles(imgFiles);
        return new BaseResult<>(ResultCode.OK, "上传成功", fileNameList);
    }
}