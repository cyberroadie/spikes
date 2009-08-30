package net.transformatorhuis.junit.agilejava;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Dump {
    int order() default Integer.MAX_VALUE;
    boolean quote() default false;
    String[] outputMethod() default "toString";
}
