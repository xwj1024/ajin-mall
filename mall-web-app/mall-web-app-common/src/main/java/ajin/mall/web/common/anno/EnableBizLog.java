package ajin.mall.web.common.anno;

import ajin.mall.web.common.aspect.BizLogAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 业务日志
 *
 * @author Ajin
 * @date 2022/04/15
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({BizLogAspect.class})
public @interface EnableBizLog {

}
