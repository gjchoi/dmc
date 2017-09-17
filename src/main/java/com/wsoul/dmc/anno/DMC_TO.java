package com.wsoul.dmc.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
//@Repeatable(value = Container.class)
public @interface DMC_TO {

	Class<?> to();
	String path();
	String excuterPath() default "";
}
