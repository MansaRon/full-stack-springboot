package com.thendo.jwt.fullstackspringboot.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
// Using the @ to define this interface as a custom annotation
public @interface ExecutionTimeLogger {}
