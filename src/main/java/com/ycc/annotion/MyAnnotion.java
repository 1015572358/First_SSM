package com.ycc.annotion;

import java.lang.annotation.*;

/**
 * @author ycc
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD})
public @interface MyAnnotion {
    String value() default "";
}
