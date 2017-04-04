package com.bloodnet.api.com.injectors;

import java.lang.reflect.Field;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.bloodnet.api.com.annotation.WebAdminLogger;

@Component
public class LogInjector implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(final Object bean, String name) throws BeansException {
		ReflectionUtils.doWithFields(bean.getClass(), new ReflectionUtils.FieldCallback() {
			public void doWith(Field field) throws IllegalArgumentException, IllegalAccessException {
				// make the field accessible if defined private
				ReflectionUtils.makeAccessible(field);
				if (field.getAnnotation(WebAdminLogger.class) != null) {
					Logger log = LogManager.getLogger(bean.getClass());
					field.set(bean, log);
				}
			}
		});
		return bean;
	}
}