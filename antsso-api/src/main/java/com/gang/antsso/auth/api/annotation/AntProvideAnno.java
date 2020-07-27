package com.gang.antsso.auth.api.annotation;

/**
 * @Classname ProvideAnno
 * @Description TODO
 * @Date 2020/6/7 16:57
 * @Created by zengzg
 */

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AntProvideAnno {

    String beanName();

    String status() default "OPEN";
}
