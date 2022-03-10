create table if not exists brand
(
    id          bigint            not null comment '品牌id'
    primary key,
    name        varchar(255)      null comment '品牌名称',
    image       varchar(255)      null comment '品牌图片',
    initials    varchar(255)      null comment '首字母',
    sort        int               null comment '排序',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '品牌表' charset = utf8;

create table if not exists category
(
    id          bigint            not null comment '分类id'
    primary key,
    parent_id   bigint            null comment '上级id',
    name        varchar(255)      null comment '分类名称',
    image       varchar(255)      null comment '分类图片',
    level       tinyint           null comment '分类级别',
    sort        int               null comment '分类排序',
    is_show     tinyint default 0 null comment '是否显示',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '商品类目表' charset = utf8;

create index parent_id
    on category (parent_id);

create table if not exists category_brand
(
    id          bigint            not null comment '主键id'
    primary key,
    category_id bigint            null comment '分类id',
    brand_id    bigint            null comment '品牌id',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
)
    comment '分类，品牌  关联表' charset = utf8;

create table if not exists evaluation
(
    id              bigint                       not null comment '主键id'
    primary key,
    sku_id          bigint                       null comment 'sku id',
    user_id         bigint                       null comment '用户id',
    order_id        bigint                       null comment '订单id',
    images          varchar(2000)                null comment '图片路径',
    description     varchar(255) charset utf8mb4 null comment '商品描述',
    goods_score     tinyint                      null comment '商品分',
    service_score   tinyint                      null comment '服务分',
    logistics_score tinyint                      null comment '物流分',
    create_time     datetime                     null comment '创建时间',
    update_time     datetime                     null comment '修改时间',
    is_delete       tinyint default 0            null comment '是否删除'
    )
    comment '商品评价表' charset = utf8;

create table if not exists freight
(
    id          bigint            not null comment '主键id'
    primary key,
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
)
    comment '运费表' charset = utf8;

create table if not exists label
(
    id          bigint            not null comment '主键id'
    primary key,
    name        varchar(255)      null comment '标签名称',
    image       varchar(255)      null comment '标签图片',
    type        tinyint           null comment '标签类型',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '标签表' charset = utf8;

create table if not exists label_goods
(
    id          bigint            not null comment '主键id'
    primary key,
    label_id    bigint            null comment '标签id',
    sku_id      bigint            null comment 'sku id',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
)
    comment '标签，商品  关联表' charset = utf8;

create table if not exists member
(
    id    bigint            not null comment '主键id'
    primary key,
    level tinyint default 0 null comment '会员等级'
)
    comment '会员表' charset = utf8;

create table if not exists param
(
    id          bigint            not null comment '主键id'
    primary key,
    template_id bigint            null comment '模板id',
    name        varchar(255)      null comment '参数名称',
    options     varchar(255)      null comment '参数选项',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '商品参数表' charset = utf8;

create table if not exists sku
(
    id           bigint                       not null comment '主键id'
    primary key,
    spu_id       bigint                       null comment 'spu id',
    sn           varchar(255) default ''      null comment '商品条码',
    code         varchar(255)                 null comment '商品编号',
    name         varchar(255) charset utf8mb4 null comment 'sku名称',
    images       varchar(2000)                null comment '商品图片',
    weight       decimal(10, 2)               null comment '商品重量,克',
    market_price decimal(10, 2)               null comment '市场价,元',
    cheap_price  decimal(10, 2)               null comment '优惠价,元',
    cost_price   decimal(10, 2)               null comment '成本价,元',
    qrcode       varchar(255)                 null comment '二维码',
    sum_num      int          default 0       null comment '库存数量',
    alert_num    int                          null comment '库存预警数',
    sale_num     int          default 0       null comment '商品销量',
    comment_num  int          default 0       null comment '评论数',
    is_check     tinyint      default 0       null comment '是否审核',
    is_market    tinyint      default 0       null comment '是否上架',
    create_time  datetime                     null comment '创建时间',
    update_time  datetime                     null comment '修改时间',
    is_delete    tinyint      default 0       null comment '是否删除'
    )
    comment '商品sku表' charset = utf8;

create index status
    on sku (is_market);

create table if not exists sku_spec
(
    id          bigint            not null comment '主键id'
    primary key,
    sku_id      bigint            null comment 'sku id',
    spec_id     bigint(11)        null comment '规格id',
    name        varchar(255)      null comment '规格名',
    value       varchar(255)      null comment '规格值',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '商品，规格  关联表' charset = utf8;

create table if not exists spec
(
    id          bigint            not null comment '主键id'
    primary key,
    template_id bigint            null comment '模板id',
    name        varchar(255)      null comment '规格名称',
    options     varchar(255)      null comment '规格选项',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '商品规格表' charset = utf8;

create table if not exists spu
(
    id           bigint            not null comment '主键id'
    primary key,
    name         varchar(255)      null comment 'spu名称',
    caption      varchar(255)      null comment '商品标题',
    details      text              null comment '商品详情',
    brand_id     bigint            null comment '品牌id',
    category1_id bigint            null comment '一级分类',
    category2_id bigint            null comment '二级分类',
    category3_id bigint            null comment '三级分类',
    create_time  datetime          null comment '创建时间',
    update_time  datetime          null comment '修改时间',
    is_delete    tinyint default 0 null comment '是否删除'
    )
    comment '商品spu表' charset = utf8;

create table if not exists spu_param
(
    id          bigint            not null comment '主键id'
    primary key,
    spu_id      bigint            null comment 'spu id',
    param_id    bigint            null comment '参数id',
    name        varchar(255)      null comment '参数名',
    value       varchar(255)      null comment '参数值',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '商品，参数  关联表';

create table if not exists sys_operate_log
(
    id             bigint       not null comment '主键id'
    primary key,
    description    varchar(255) null comment '操作描述',
    request_info   text         null comment '请求信息',
    response_info  text         null comment '响应信息',
    exception_info text         null comment '异常信息',
    create_time    datetime     null comment '创建时间',
    update_time    datetime     null comment '修改时间',
    is_delete      tinyint      null comment '是否删除'
    )
    comment '系统操作日志表' charset = utf8;

create table if not exists sys_permission
(
    id          bigint            not null comment '主键id'
    primary key,
    name        varchar(255)      null comment '名称',
    keyword     varchar(255)      null comment '关键字',
    note        varchar(255)      null comment '备注',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '系统权限表';

create table if not exists sys_role
(
    id          bigint            not null comment '主键id'
    primary key,
    name        varchar(255)      null comment '名称',
    keyword     varchar(255)      null comment '关键字',
    description varchar(255)      null comment '备注，描述',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '系统角色表';

create table if not exists sys_role_permission
(
    id                bigint            not null comment '主键id'
    primary key,
    sys_role_id       bigint            null comment '系统角色id',
    sys_permission_id bigint            null comment '系统权限id',
    create_time       datetime          null comment '创建时间',
    update_time       datetime          null comment '修改时间',
    is_delete         tinyint default 0 null comment '是否删除'
)
    comment '系统角色，系统权限  关联表';

create table if not exists sys_user
(
    id          bigint        not null comment '主键id'
    primary key,
    username    varchar(255)  null comment '账号',
    password    varchar(255)  null comment '密码',
    nickname    varchar(255)  null comment '昵称',
    avatar      varchar(255)  null comment '头像',
    description varchar(255)  null comment '备注，描述',
    state       int default 0 null comment '状态信息：0全部，1正常，2禁用，4锁定，8过期',
    create_time datetime      null comment '创建时间',
    update_time datetime      null comment '修改时间',
    is_delete   tinyint       null comment '是否删除'
    )
    comment '系统用户表' charset = utf8;

create table if not exists sys_user_role
(
    id          bigint            not null comment '主键id'
    primary key,
    sys_user_id bigint            null comment '系统用户id',
    sys_role_id bigint            null comment '系统角色id',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
)
    comment '系统用户，角色  关联表' charset = utf8;

create table if not exists template
(
    id          bigint            not null comment '主键id'
    primary key,
    category_id bigint            null comment '分类id',
    name        varchar(255)      null comment '模板名称',
    create_time datetime          null comment '创建时间',
    update_time datetime          null comment '修改时间',
    is_delete   tinyint default 0 null comment '是否删除'
    )
    comment '规格，参数  模板表' charset = utf8;

