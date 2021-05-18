package cn.leemay.mall.common.data.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Ajin
 * @since 2021-04-29
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("addTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("addDate", LocalDate.now(), metaObject);

        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("createDate", LocalDate.now(), metaObject);

        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateDate", LocalDate.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateDate", LocalDate.now(), metaObject);
    }
}
