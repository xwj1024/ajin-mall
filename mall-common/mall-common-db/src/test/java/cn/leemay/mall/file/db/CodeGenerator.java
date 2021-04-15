package cn.leemay.mall.file.db;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * 代码生成器 mybatis-plus
 *
 * @author Ajin
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 构建代码生成器对象
        AutoGenerator ag = new AutoGenerator();

        /*
         设置配置信息
        */
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/mall-service/mall-service-goods/src/main/java");
        gc.setAuthor("Ajin");
        gc.setOpen(false);
        gc.setFileOverride(false);
        gc.setServiceName("%sService");
        gc.setIdType(IdType.ASSIGN_ID);
        gc.setDateType(DateType.ONLY_DATE);
        gc.setSwagger2(true);
        ag.setGlobalConfig(gc);
        // 设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://leemay.cn:3306/leemay_mall?characterEncoding=UTF8&serverTimezone=Asia/Shanghai&useSSL=false");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("ajin");
        dsc.setPassword("Spring.222");
        dsc.setDbType(DbType.MYSQL);
        ag.setDataSource(dsc);
        // 包的配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.leemay.mall");
        pc.setModuleName("goods");
        ag.setPackageInfo(pc);
        // 策略配置
        StrategyConfig sc = new StrategyConfig();
        sc.setInclude("template"); // 设置要映射的表名
        sc.setNaming(NamingStrategy.underline_to_camel);
        sc.setColumnNaming(NamingStrategy.underline_to_camel);
        sc.setEntityLombokModel(true);
        sc.setRestControllerStyle(true);
        sc.setLogicDeleteFieldName("is_delete");
        // 自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        List<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        sc.setTableFillList(tableFills);
        sc.setVersionFieldName("version"); // 乐观锁
        sc.setControllerMappingHyphenStyle(true);
        ag.setStrategy(sc);
        // 执行
        ag.execute();

        /*
         * javax.net.ssl.SSLException
         * 需要在数据库连接url上添加 useSSL=false
         *
         * java.lang.NoClassDefFoundError: org/apache/velocity/context/Context
         * 需要添加依赖 'org.apache.velocity:velocity-engine-core:2.0'
         */


        /**
         * todo
         * 将图片存入redis把多余图片用定时任务进行删除,redis中的key也要加入定时任务,设置过期时间
         * 学习redis使用注解怎么配置!深入学习redis原理
         * 学习autowired和resource 区别! 深入学习elasticsearch!
         * 学习日志!
         */

    }
}
