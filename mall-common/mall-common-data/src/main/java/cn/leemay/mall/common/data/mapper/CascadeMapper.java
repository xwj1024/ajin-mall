package cn.leemay.mall.common.data.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Ajin
 */
public interface CascadeMapper {

    /**
     * 获取关联表中数据数量
     *
     * @param arg             参数
     * @param linkedTableName 表名
     * @param linkedFieldName 字段
     * @return 结果数量
     */
    @Select("select count(*) from `${linkedTableName}` where `${linkedFieldName}` = #{arg} and is_delete = 0")
    int count(@Param("arg") Long arg, @Param("linkedTableName") String linkedTableName, @Param("linkedFieldName") String linkedFieldName);

    /**
     * 删除关联表中数据
     *
     * @param arg             参数
     * @param linkedTableName 表名
     * @param linkedFieldName 字段
     * @return 删除结果
     */
    @Update("update `${linkedTableName}` set is_delete = 1 where `${linkedFieldName}` = #{arg}")
    int delete(@Param("arg") Long arg, @Param("linkedTableName") String linkedTableName, @Param("linkedFieldName") String linkedFieldName);

}
