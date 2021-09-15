package com.usst.annotate;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public @interface Table {

    String name();
}
