package ajin.mall.sys.search.controller;

import ajin.mall.common.base.result.BaseResult;
import ajin.mall.common.base.result.ResultCode;
import ajin.mall.sys.search.service.EsManageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


/**
 * @author Ajin
 * @since 2021-04-14
 */
@RestController
@RequestMapping("/api/search/es")
@Api(tags = "es管理")
@CrossOrigin
public class EsManageController {

    @Autowired
    private EsManageService esManageService;

    @PostMapping("/create")
    @ApiOperation("构建索引结构")
    public BaseResult<String> createIndex() throws IOException {
        esManageService.createIndex();
        return new BaseResult<>(ResultCode.OK, "创建索引结构成功");
    }

    @PostMapping("/import")
    @ApiOperation("导入全部数据")
    public BaseResult<String> importBatch() {
        esManageService.importBatch();
        return new BaseResult<>(ResultCode.OK,"导入全部数据成功");
    }
}
