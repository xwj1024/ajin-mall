package cn.leemay.mall.tool.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ajin
 * @since 2021-06-16
 */
@RestController
@RequestMapping("/tool/downloadFile")
@Api(tags = "文件下载")
@CrossOrigin
public class DownloadFileController {
}
