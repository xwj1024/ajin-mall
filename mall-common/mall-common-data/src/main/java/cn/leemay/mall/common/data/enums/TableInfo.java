package cn.leemay.mall.common.data.enums;

/**
 * @author Ajin
 */
public enum TableInfo {

    BRAND("brand", "品牌"),
    CATEGORY("category", "分类"),
    CATEGORY_BRAND("category_brand", "分类，品牌"),
    SPU("spu", "SPU"),
    SKU("sku", "SKU"),
    ORDER("order", "订单"),
    ADDRESS("address", "地址"),
    USER("user", "用户");

    private final String name;
    private final String desc;

    TableInfo(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public static String getDescByName(String name) {
        for (TableInfo tableInfo : TableInfo.values()) {
            if (name.equals(tableInfo.getName())) {
                return tableInfo.getDesc();
            }
        }
        return "";
    }

}
