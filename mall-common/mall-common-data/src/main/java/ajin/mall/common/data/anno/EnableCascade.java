package ajin.mall.common.data.anno;

import ajin.mall.common.data.handler.CascadeDeleteHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Ajin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({CascadeDeleteHandler.class})
public @interface EnableCascade {
}
