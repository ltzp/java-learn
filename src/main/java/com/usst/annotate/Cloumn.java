package com.usst.annotate;


import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Cloumn {
    String name();
    String type();
    boolean pk() default false;
    String dec() default "";
}
