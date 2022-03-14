package cn.leemay.mall.common.data.enums;

/**
 * @author Ajin
 */
public enum TableInfo {

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
