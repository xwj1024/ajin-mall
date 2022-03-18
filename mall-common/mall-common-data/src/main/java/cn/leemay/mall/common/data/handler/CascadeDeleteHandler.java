package cn.leemay.mall.common.data.handler;

import cn.leemay.mall.common.data.anno.CascadeDelete;
import cn.leemay.mall.common.data.anno.CascadeField;
import cn.leemay.mall.common.data.enums.TableInfo;
import cn.leemay.mall.common.data.mapper.CascadeMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author Ajin
 */
@Component
@Aspect
@Slf4j
public class CascadeDeleteHandler {

    @Pointcut("@annotation(cn.leemay.mall.common.data.anno.CascadeDelete)")
    public void cascadeDeletePointCut() {
    }

    @AfterReturning(pointcut = "@annotation(cascadeDelete)", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, CascadeDelete cascadeDelete, Object jsonResult) {
        Object[] args = joinPoint.getArgs();
        Long     arg  = (Long) args[0];
        handleCascadeDelete(cascadeDelete, arg);
    }

    @Value("${cascadeFieldPackageName:cn.leemay.mall.common.data.entity}")
    private String cascadeFieldPackageName;

    public void handleCascadeDelete(CascadeDelete cascadeDelete, Long arg) {
        // 获取要删除的主表名
        String      tableName   = cascadeDelete.value().getName();
        Reflections reflections = new Reflections(cascadeFieldPackageName, new FieldAnnotationsScanner());
        // 获取扫描到的标记注解的集合
        Set<Field> fields = reflections.getFieldsAnnotatedWith(CascadeField.class);
        for (Field field : fields) {
            CascadeField cascadeFieldAnno = field.getDeclaredAnnotation(CascadeField.class);
            String       sourceTableName  = cascadeFieldAnno.sourceTable().getName();
            // 判断删除的主表是否有关联表
            if (tableName.equals(sourceTableName)) {
                String linkedTableName = cascadeFieldAnno.linkedTable().getName();
                String linkedFieldName = cascadeFieldAnno.linkedField();
                // 如果有关联表，判断是否能直接删除
                if (cascadeFieldAnno.enableDelete()) {
                    // 如果能直接删关联表数据
                    int row = delete(arg, linkedTableName, linkedFieldName);
                    log.warn("{}表删除数据，{}表级联删除：{}条数据", sourceTableName, linkedTableName, row);
                } else {
                    // 如果不能直接删，判断关联表是否有关联数据
                    int    count = count(arg, linkedTableName, linkedFieldName);
                    String desc  = TableInfo.getDescByName(linkedTableName);
                    Assert.isTrue(count == 0, desc + "已有关联，无法删除");
                }
            }
        }
    }

    @Resource
    private CascadeMapper cascadeMapper;

    /**
     * 获取关联表数据条数
     *
     * @return 数量
     */
    private int count(Long arg, String linkedTableName, String linkedFieldName) {
        return cascadeMapper.count(arg, linkedTableName, linkedFieldName);
    }

    /**
     * 删除关联表数据
     *
     * @return 删除条数
     */
    private int delete(Long arg, String linkedTableName, String linkedFieldName) {
        return cascadeMapper.delete(arg, linkedTableName, linkedFieldName);
    }
}
