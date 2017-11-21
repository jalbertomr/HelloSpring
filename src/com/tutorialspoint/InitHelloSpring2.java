package com.tutorialspoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class InitHelloSpring2 implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + ": BeforeInitialization: " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + ": AfterInitialization: " + s);
        return o;
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
