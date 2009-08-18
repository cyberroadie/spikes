package net.transformatorhuis.junit.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 *
 * @author cyberroadie
 */
public class ObjectDumper {

    static final int MAX_DEPTH = 2;
    static int depth = 0;

    public static String dumpObject(Object object) {
        Class clazz = object.getClass();
        return printFields(clazz.getDeclaredFields(), "");
    }

    private static String printFields(Field[] fields, String prefix) {
        depth++;
        StringBuilder sb = new StringBuilder();
        for (Field field : fields) {
            sb.append(prefix + "Field: " + field.getName());
            sb.append(" Type: " + field.getType().getSimpleName());
            if(Modifier.STATIC == field.getModifiers()) {
                sb.append(" (static) ");
            }
            sb.append("\n");
            Package aPackage = field.getType().getPackage();
            if (aPackage != null && depth < MAX_DEPTH) {
                if (!aPackage.getName().startsWith("javax.") || !aPackage.getName().startsWith("java.")) {
                    sb.append(printFields(field.getType().getDeclaredFields(), "-" + prefix));
                }
            }
        }
        return sb.toString();
    }
}
