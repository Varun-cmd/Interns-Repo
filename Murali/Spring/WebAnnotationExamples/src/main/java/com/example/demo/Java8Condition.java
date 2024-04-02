package com.example.demo;

import org.springframework.boot.system.JavaVersion;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;



class Java8Condition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return JavaVersion.getJavaVersion().equals(JavaVersion.TWENTY_ONE);
    }

}