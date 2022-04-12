/*
 Date: 2022/04/07
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address`
(
    `id`          bigint                                                        NOT NULL COMMENT '地址id',
    `member_id`   bigint                                                        NOT NULL DEFAULT '0' COMMENT '会员id',
    `province`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '省',
    `city`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '市',
    `area`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '区县',
    `town`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '乡镇',
    `detail`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '详细地址',
    `sort`        int                                                           NOT NULL DEFAULT '999' COMMENT '排序',
    `is_default`  tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否默认',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员地址表';

-- ----------------------------
-- Table structure for brand
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand`
(
    `id`          bigint                                                        NOT NULL COMMENT '品牌id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品牌名称',
    `initial`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '首字母',
    `image`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '品牌图片',
    `sort`        int                                                           NOT NULL DEFAULT '999' COMMENT '排序',
    `is_show`     tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否显示',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品品牌表';

-- ----------------------------
-- Table structure for browse
-- ----------------------------
DROP TABLE IF EXISTS `browse`;
CREATE TABLE `browse`
(
    `id`          bigint   NOT NULL COMMENT '浏览记录id',
    `member_id`   bigint   NOT NULL DEFAULT '0' COMMENT '会员id',
    `spu_id`      bigint   NOT NULL DEFAULT '0' COMMENT 'spu id',
    `browse_time` datetime NOT NULL COMMENT '浏览时间',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员浏览记录表';

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart`
(
    `id`          bigint   NOT NULL COMMENT '购物车id',
    `member_id`   bigint   NOT NULL DEFAULT '0' COMMENT '会员id',
    `sku_id`      bigint   NOT NULL DEFAULT '0' COMMENT 'sku id',
    `num`         int      NOT NULL DEFAULT '1' COMMENT '数量',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员购物车表';

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`
(
    `id`          bigint                                                        NOT NULL COMMENT '分类id',
    `parent_id`   bigint                                                        NOT NULL DEFAULT '0' COMMENT '上级id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '分类名称',
    `image`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '分类图片',
    `level`       tinyint                                                       NOT NULL DEFAULT '0' COMMENT '分类级别',
    `sort`        int                                                           NOT NULL DEFAULT '999' COMMENT '分类排序',
    `is_show`     tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否显示',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`),
    KEY           `parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品类目表';

-- ----------------------------
-- Table structure for category_brand
-- ----------------------------
DROP TABLE IF EXISTS `category_brand`;
CREATE TABLE `category_brand`
(
    `id`          bigint   NOT NULL COMMENT '主键id',
    `category_id` bigint   NOT NULL DEFAULT '0' COMMENT '分类id',
    `brand_id`    bigint   NOT NULL DEFAULT '0' COMMENT '品牌id',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品分类，商品品牌  关联表';

-- ----------------------------
-- Table structure for common_file
-- ----------------------------
DROP TABLE IF EXISTS `common_file`;
CREATE TABLE `common_file`
(
    `id`          bigint   NOT NULL COMMENT '文件id',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公共文件表';

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company`
(
    `id`          bigint                                  NOT NULL COMMENT '公司id',
    `name`        varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '公司名称',
    `image`       varchar(200) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '公司图片',
    `create_time` datetime                                NOT NULL COMMENT '创建时间',
    `update_time` datetime                                NOT NULL COMMENT '修改时间',
    `version`     int                                     NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                 NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='公司表';

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`
(
    `id`          bigint                                  NOT NULL COMMENT '部门id',
    `company_id`  bigint                                  NOT NULL DEFAULT '0' COMMENT '公司id',
    `name`        varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门名称',
    `image`       varchar(200) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '部门图片',
    `sort`        int                                     NOT NULL DEFAULT '999' COMMENT '排序',
    `create_time` datetime                                NOT NULL COMMENT '创建时间',
    `update_time` datetime                                NOT NULL COMMENT '修改时间',
    `version`     int                                     NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                 NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='部门表';

-- ----------------------------
-- Table structure for evaluation
-- ----------------------------
DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE `evaluation`
(
    `id`            bigint                                                         NOT NULL COMMENT '主键id',
    `member_id`     bigint                                                         NOT NULL DEFAULT '0' COMMENT '会员id',
    `sku_id`        bigint                                                         NOT NULL DEFAULT '0' COMMENT 'sku id',
    `order_id`      bigint                                                         NOT NULL DEFAULT '0' COMMENT '订单id',
    `images`        varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '图片路径',
    `content`   varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '商品描述',
    `goods_score`   tinyint                                                        NOT NULL DEFAULT '10' COMMENT '商品分',
    `service_score` tinyint                                                        NOT NULL DEFAULT '10' COMMENT '服务分',
    `express_score` tinyint                                                        NOT NULL DEFAULT '10' COMMENT '物流分',
    `create_time`   datetime                                                       NOT NULL COMMENT '创建时间',
    `update_time`   datetime                                                       NOT NULL COMMENT '修改时间',
    `version`       int                                                            NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`     tinyint                                                        NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品评价表';

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite`
(
    `id`            bigint   NOT NULL COMMENT '主键id',
    `member_id`     bigint   NOT NULL DEFAULT '0' COMMENT '会员id',
    `spu_id`        bigint   NOT NULL DEFAULT '0' COMMENT 'spu id',
    `favorite_time` datetime NOT NULL COMMENT '收藏时间',
    `create_time`   datetime NOT NULL COMMENT '创建时间',
    `update_time`   datetime NOT NULL COMMENT '修改时间',
    `version`       int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`     tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员收藏表';

-- ----------------------------
-- Table structure for freight
-- ----------------------------
DROP TABLE IF EXISTS `freight`;
CREATE TABLE `freight`
(
    `id`          bigint   NOT NULL COMMENT '主键id',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品运费表';

-- ----------------------------
-- Table structure for label
-- ----------------------------
DROP TABLE IF EXISTS `label`;
CREATE TABLE `label`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签名称',
    `image`       varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标签图片',
    `type`        tinyint                                                       NOT NULL COMMENT '标签类型',
    `sort`        int                                                           NOT NULL DEFAULT '999' COMMENT '排序',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品标签表';

-- ----------------------------
-- Table structure for label_goods
-- ----------------------------
DROP TABLE IF EXISTS `label_goods`;
CREATE TABLE `label_goods`
(
    `id`          bigint   NOT NULL COMMENT '主键id',
    `label_id`    bigint   NOT NULL COMMENT '标签id',
    `sku_id`      bigint   NOT NULL COMMENT 'sku id',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品标签，商品  关联表';

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `username`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '账号',
    `password`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    `nickname`    varchar(100) COLLATE utf8mb4_general_ci                       NOT NULL DEFAULT '' COMMENT '会员昵称',
    `age`         int                                                           NOT NULL DEFAULT '0' COMMENT '会员年龄',
    `phone`       varchar(20) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '' COMMENT '手机号',
    `email`       varchar(50) COLLATE utf8mb4_general_ci                        NOT NULL DEFAULT '' COMMENT '会员邮箱',
    `level`       tinyint                                                       NOT NULL DEFAULT '0' COMMENT '会员等级',
    `state`       int                                                           NOT NULL DEFAULT '1' COMMENT '状态信息：0全部，1正常',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员表';

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`
(
    `id`          bigint   NOT NULL COMMENT '主键id',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='会员订单表';

-- ----------------------------
-- Table structure for param
-- ----------------------------
DROP TABLE IF EXISTS `param`;
CREATE TABLE `param`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `template_id` bigint                                                        NOT NULL DEFAULT '0' COMMENT '模板id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数名称',
    `options`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数选项',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品参数表';

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `keyword`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '关键字',
    `path`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '路径',
    `method`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '方法',
    `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注，描述',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='权限表';

-- ----------------------------
-- Table structure for region
-- ----------------------------
DROP TABLE IF EXISTS `region`;
CREATE TABLE `region`
(
    `id`          bigint                                                       NOT NULL COMMENT '主键id',
    `parent_id`   bigint                                                       NOT NULL DEFAULT '0' COMMENT '上级id',
    `code`        varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '编码',
    `name`        varchar(50) COLLATE utf8mb4_general_ci                       NOT NULL DEFAULT '' COMMENT '名称',
    `edition`     varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '版本信息：2020版，2022版',
    `create_time` datetime                                                     NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                     NOT NULL COMMENT '修改时间',
    `version`     int                                                          NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                      NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='行政区划表';

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
    `keyword`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '关键字',
    `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注，描述',
    `sort`        int                                                           NOT NULL DEFAULT '999' COMMENT '排序',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色表';

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`
(
    `id`            bigint   NOT NULL COMMENT '主键id',
    `role_id`       bigint   NOT NULL DEFAULT '0' COMMENT '系统角色id',
    `permission_id` bigint   NOT NULL DEFAULT '0' COMMENT '系统权限id',
    `create_time`   datetime NOT NULL COMMENT '创建时间',
    `update_time`   datetime NOT NULL COMMENT '修改时间',
    `version`       int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`     tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='角色，权限  关联表';

-- ----------------------------
-- Table structure for sku
-- ----------------------------
DROP TABLE IF EXISTS `sku`;
CREATE TABLE `sku`
(
    `id`              bigint                                                         NOT NULL COMMENT '主键id',
    `spu_id`          bigint                                                         NOT NULL DEFAULT '0' COMMENT 'spu id',
    `sn`              varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '商品条码',
    `code`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '商品编号',
    `name`            varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT 'sku名称',
    `images`          varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品图片',
    `market_price`    decimal(10, 2)                                                 NOT NULL COMMENT '市场价,元',
    `cheap_price`     decimal(10, 2)                                                 NOT NULL COMMENT '优惠价,元',
    `cost_price`      decimal(10, 2)                                                 NOT NULL COMMENT '成本价,元',
    `qrcode`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NOT NULL DEFAULT '' COMMENT '二维码',
    `stock_num`       int                                                            NOT NULL DEFAULT '0' COMMENT '库存数量',
    `alert_num`       int                                                            NOT NULL DEFAULT '0' COMMENT '库存预警数',
    `sale_num`        int                                                            NOT NULL DEFAULT '0' COMMENT '商品销量',
    `evaluate_num`    int                                                            NOT NULL DEFAULT '0' COMMENT '评论数',
    `is_check`        tinyint                                                        NOT NULL DEFAULT '0' COMMENT '是否审核',
    `is_market`       tinyint                                                        NOT NULL DEFAULT '0' COMMENT '是否上架',
    `is_invalid`      tinyint                                                        NOT NULL DEFAULT '0' COMMENT '是否作废',
    `on_market_time`  datetime                                                       NOT NULL COMMENT '上架时间',
    `off_market_time` datetime                                                       NOT NULL COMMENT '下架时间',
    `create_time`     datetime                                                       NOT NULL COMMENT '创建时间',
    `update_time`     datetime                                                       NOT NULL COMMENT '修改时间',
    `version`         int                                                            NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`       tinyint                                                        NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品sku表';

-- ----------------------------
-- Table structure for sku_spec
-- ----------------------------
DROP TABLE IF EXISTS `sku_spec`;
CREATE TABLE `sku_spec`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `sku_id`      bigint                                                        NOT NULL DEFAULT '0' COMMENT 'sku id',
    `spec_id`     bigint                                                        NOT NULL DEFAULT '0' COMMENT '规格id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规格名',
    `value`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规格值',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品，商品规格  关联表';

-- ----------------------------
-- Table structure for spec
-- ----------------------------
DROP TABLE IF EXISTS `spec`;
CREATE TABLE `spec`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `template_id` bigint                                                        NOT NULL DEFAULT '0' COMMENT '模板id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规格名称',
    `options`     varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '规格选项',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品规格表';

-- ----------------------------
-- Table structure for spu
-- ----------------------------
DROP TABLE IF EXISTS `spu`;
CREATE TABLE `spu`
(
    `id`           bigint                                                        NOT NULL COMMENT '主键id',
    `name`         varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT 'spu名称',
    `caption`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '商品标题',
    `details`      text COLLATE utf8mb4_general_ci                               NOT NULL COMMENT '商品详情',
    `brand_id`     bigint                                                        NOT NULL DEFAULT '0' COMMENT '品牌id',
    `category1_id` bigint                                                        NOT NULL DEFAULT '0' COMMENT '一级分类',
    `category2_id` bigint                                                        NOT NULL DEFAULT '0' COMMENT '二级分类',
    `category3_id` bigint                                                        NOT NULL DEFAULT '0' COMMENT '三级分类',
    `create_time`  datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`  datetime                                                      NOT NULL COMMENT '修改时间',
    `version`      int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`    tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品spu表';

-- ----------------------------
-- Table structure for spu_param
-- ----------------------------
DROP TABLE IF EXISTS `spu_param`;
CREATE TABLE `spu_param`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `spu_id`      bigint                                                        NOT NULL DEFAULT '0' COMMENT 'spu id',
    `param_id`    bigint                                                        NOT NULL DEFAULT '0' COMMENT '参数id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数名',
    `value`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '参数值',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品，商品参数  关联表';

-- ----------------------------
-- Table structure for sys_log
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log`
(
    `id`              bigint                                                        NOT NULL COMMENT '主键id',
    `sys_user_id`     bigint                                                        NOT NULL DEFAULT '0' COMMENT '系统用户id',
    `description`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '操作描述',
    `remote_ip`       varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '远程IP',
    `request_uri`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求路径',
    `request_method`  varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '请求方法',
    `method_name`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '方法名称',
    `request_param`   text COLLATE utf8mb4_general_ci COMMENT '请求参数',
    `response_result` text COLLATE utf8mb4_general_ci COMMENT '响应结果',
    `source_data`     text COLLATE utf8mb4_general_ci COMMENT '原始数据',
    `exception_info`  text COLLATE utf8mb4_general_ci COMMENT '异常信息',
    `operate_time`    datetime                                                      NOT NULL COMMENT '操作时间',
    `create_time`     datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time`     datetime                                                      NOT NULL COMMENT '修改时间',
    `version`         int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`       tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='系统日志表';

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `category_id` bigint                                                        NOT NULL DEFAULT '0' COMMENT '分类id',
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '模板名称',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品规格，商品参数  模板表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          bigint                                                        NOT NULL COMMENT '主键id',
    `username`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '账号',
    `password`    varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
    `nickname`    varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '昵称',
    `avatar`      varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '头像',
    `remark` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '备注，描述',
    `state`       int                                                           NOT NULL DEFAULT '1' COMMENT '状态信息：0全部，1账号正常，2账号禁用，4账号锁定，8账号过期，16密码过期',
    `login_time`  datetime                                                               DEFAULT NULL COMMENT '登录时间',
    `create_time` datetime                                                      NOT NULL COMMENT '创建时间',
    `update_time` datetime                                                      NOT NULL COMMENT '修改时间',
    `version`     int                                                           NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint                                                       NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`
(
    `id`          bigint   NOT NULL COMMENT '主键id',
    `user_id`     bigint   NOT NULL DEFAULT '0' COMMENT '系统用户id',
    `role_id`     bigint   NOT NULL DEFAULT '0' COMMENT '系统角色id',
    `create_time` datetime NOT NULL COMMENT '创建时间',
    `update_time` datetime NOT NULL COMMENT '修改时间',
    `version`     int      NOT NULL DEFAULT '0' COMMENT '版本号',
    `is_delete`   tinyint  NOT NULL DEFAULT '0' COMMENT '是否删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户，角色  关联表';

SET
FOREIGN_KEY_CHECKS = 1;
