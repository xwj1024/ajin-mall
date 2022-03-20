package ajin.mall.common.base.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ajin
 * @since 2021-05-21
 */
public class ClassUtils {

    public static final String SERIAL_VERSION_UID = "serialVersionUID";

    public static String[] getColumns(Class<?> clazz) {
        Field[]      fields   = clazz.getDeclaredFields();
        List<String> nameList = new ArrayList<>();
        for (Field field : fields) {
            field.setAccessible(true);
            if (!SERIAL_VERSION_UID.equals(field.getName())) {
                nameList.add(StringUtils.hump2Line(field.getName()));
            }
        }
        String[] columns = new String[nameList.size()];
        return nameList.toArray(columns);
    }
}
