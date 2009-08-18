package net.transformatorhuis.junit.agilejava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 *
 * @author cyberroadie
 */
public class ReflectionCloner {

    public ReflectionCloner(String test) {
        
    }

    public Object cloneViaReflection(Object object) throws CloneViaReflectionExcpetion {
        if(!hasNoArgumentConstructor(object.getClass().getConstructors())) {
            throw new CloneViaReflectionExcpetion("Has no no argument constructors");
        }
        Object clonedObject;
        try {
            clonedObject = object.getClass().newInstance();
        } catch (InstantiationException ex) {
            throw new CloneViaReflectionExcpetion(ex.toString());
        } catch (IllegalAccessException ex) {
            throw new CloneViaReflectionExcpetion(ex.toString());
        }

        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            try {
                try {
                    clonedObject.getClass().getDeclaredField(field.getName()).set(object.getClass().getDeclaredField(field.getName()).get(object), object);
                } catch (IllegalArgumentException ex) {
                    throw new CloneViaReflectionExcpetion(ex.toString());
                } catch (IllegalAccessException ex) {
                    throw new CloneViaReflectionExcpetion(ex.toString());
                }
            } catch (NoSuchFieldException ex) {
                throw new CloneViaReflectionExcpetion(ex.toString());
            } catch (SecurityException ex) {
                throw new CloneViaReflectionExcpetion(ex.toString());
            }
        }

        return clonedObject;
    }

    private boolean hasNoArgumentConstructor(Constructor[] cons) {
        for (Constructor constructor : cons) {
            if(constructor.getGenericParameterTypes().length == 0) {
                return true;
            }
        }
        // No empty constructors found
        return false;
    }

    public class CloneViaReflectionExcpetion extends Exception {

        public CloneViaReflectionExcpetion() {
            super();
        }

        public CloneViaReflectionExcpetion(String message) {
            super(message);
        }
    }
    
}
