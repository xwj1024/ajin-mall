package cn.leemay.mall.common.data.anno;

import cn.leemay.mall.common.data.handler.CascadeDeleteHandler;
import cn.leemay.mall.common.data.mapper.CascadeMapper;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CascadeDeleteHandler.class, CascadeMapper.class})
public @interface EnableCascadeDelete {
}
