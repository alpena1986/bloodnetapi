package com.bloodnet.bloodnetapi.com.appconfig;

import java.util.Locale;

import javax.validation.MessageInterpolator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
public class SpringMessageInterpolator implements MessageInterpolator {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	public String interpolate(String messageTemplate, Context context) {
//		String[] params = (String[]) context.getConstraintDescriptor().getAttributes().get("params");
//		MessageBuilder builder = new MessageBuilder().code(messageTemplate);
//		if (params != null) {
//			for (String param : params) {
//				builder = builder.arg(param);
//			}
//		}
//		return builder.build().resolveMessage(messageSource, Locale.FRANCE).getText();
		return "1";
	}
	@Override
	public String interpolate(String messageTemplate, Context context, Locale locale) {
//		String[] params = (String[]) context.getConstraintDescriptor().getAttributes().get("params");
//		MessageBuilder builder = new MessageBuilder().code(messageTemplate);
//		if (params != null) {
//			builder = builder.args(params);
//		}
//		return builder.build().resolveMessage(messageSource, local).getText();
		return "1";
	}
}