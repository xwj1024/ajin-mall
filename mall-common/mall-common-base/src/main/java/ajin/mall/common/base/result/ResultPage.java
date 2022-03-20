package ajin.mall.common.base.result;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ajin
 * @since 2021-04-12
 */
@Data
public class ResultPage<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 总条数
     */
    private long total;

    /**
     * 当前页数据
     */
    private List<T> data;

    public ResultPage() {
    }

    public ResultPage(long total, List<T> data) {
        this.total = total;
        this.data = data;
    }

    public ResultPage(PageInfo<T> pageInfo) {
        this.total = pageInfo.getTotal();
        this.data = pageInfo.getList();
    }
}
