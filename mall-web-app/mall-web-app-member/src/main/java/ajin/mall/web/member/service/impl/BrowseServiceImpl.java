package ajin.mall.web.member.service.impl;

import ajin.mall.common.base.asserts.BizAssert;
import ajin.mall.common.base.result.ResultPage;
import ajin.mall.common.data.entity.Browse;
import ajin.mall.web.member.form.BrowseListForm;
import ajin.mall.web.member.mapper.BrowseMapper;
import ajin.mall.web.member.service.BrowseService;
import ajin.mall.web.member.view.BrowseView;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 浏览服务impl
 *
 * @author Ajin
 * @date 2022/04/14
 */
@Service
public class BrowseServiceImpl implements BrowseService {

    @Resource
    private BrowseMapper browseMapper;

    @Override
    public void delete(Long id) {
        Browse existBrowse = browseMapper.selectById(id);
        BizAssert.notNull(existBrowse, "该记录不存在");

        int affectRow = browseMapper.deleteById(id);
        BizAssert.isTrue(affectRow == 1, "删除失败");
    }

    @Override
    public ResultPage<BrowseView> list(BrowseListForm browseListForm) {
        return null;
    }
}
