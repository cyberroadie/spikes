package net.transformatorhuis.junit.util;

import java.lang.reflect.Field;

/**
 *
 * @author cyberroadie
 */
public class ObjectDumper {

    public static String dumpObject(Object object) {
        Class clazz = object.getClass();
        return printFields(clazz.getFields(), "");
    }

    private static String printFields(Field[] fields, String prefix) {
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            String packageName = field.getType().getPackage().getName();
            sb.append("Field: " + field.getName());
            sb.append(" Object: " + field.getType().getSimpleName() + "\n");
            if(!packageName.startsWith("javax.") || !packageName.startsWith("java.")) {
                sb.append(printFields(field.getType().getFields(), "-" + prefix));
            }
        }
        return sb.toString();
    }
    
}
