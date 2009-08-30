package net.transformatorhuis.junit.agilejava;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author cyberroadie
 */
public class ToStringer {

    /**
     * Map wich can contain multiple values on the same key
     */
    SortedMap<Integer, List<Field>> sortedMap;

    public void analyze(Object object) {
        Field[] fields = object.getClass().getFields();
        sortedMap = new TreeMap<Integer, List<Field>>() {
        };
        for (Field field : fields) {
            if (field.isAnnotationPresent(Dump.class)) {
                int order = field.getAnnotation(Dump.class).order();
                List list = sortedMap.get(order);
                if (list == null) {
                    list = new ArrayList<Field>();
                    list.add(field);
                    sortedMap.put(order, list);
                } else {
                    list.add(field);
                    sortedMap.put(order, list);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Collection<List<Field>> fieldCollection = sortedMap.values();
        for (List<Field> list : fieldCollection) {
            for (Field field : list) {
                if (field.getAnnotation(Dump.class).quote()) {
                    sb.append("'" + processOutputMethods(field) + "'\n");
                } else {
                    sb.append(processOutputMethods(field) + "\n");
                }
            }
        }
        return sb.toString();
    }

    private String processOutputMethods(Field field) {
        String[] outputMethods = field.getAnnotation(Dump.class).outputMethod();
        StringBuilder sb = new StringBuilder();
        for (String method : outputMethods) {
            if (method.equals("toSimpleType")) {
                sb.append(toSimpleType(field));
            }
            if (method.equals("toType")) {
                sb.append(toType(field));
            }
            if (method.equals("toString")){
                sb.append(field.toString());
            }
        }
        return sb.toString();
    }

    private String toSimpleType(Field field) {
        return field.getType().getSimpleName() + " type.";
    }

    private String toType(Field field) {
        return field.getType().getName() + " type.";
    }
}
