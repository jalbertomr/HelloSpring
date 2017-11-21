package com.tutorialspoint;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

public class InitHelloSpring implements BeanPostProcessor, Ordered{
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + ": BeforeInitialization: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(this.getClass().getSimpleName() + ": AfterInitialization: " + beanName);
        return bean;
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
