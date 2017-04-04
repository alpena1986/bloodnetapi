package com.bloodnet.api.com.appconfig;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//import jp.ne.uvas.lilliputway.admin.com.LogSessionIdFilter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.RequestContextFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.IntrospectorCleanupListener;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		// encodingFilter
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");

		// requestContextFilter
		FilterRegistration.Dynamic requestContextFilter = servletContext.addFilter("requestContextFilter", new RequestContextFilter());
		requestContextFilter.addMappingForUrlPatterns(null, false, "/*");

//		FilterRegistration.Dynamic logSessionIdFilter = servletContext.addFilter("logSessionIdFilter", new LogSessionIdFilter());
//		logSessionIdFilter.addMappingForUrlPatterns(null, false, "/*");

		// xss filter
		// FilterRegistration.Dynamic xSSFilter =
		// servletContext.addFilter("XSSFilter", new XSSFilter());
		// xSSFilter.addMappingForUrlPatterns(null, false, "/*");

		// listeners
		// servletContext.addListener(ContextLoaderListener.class);
		RequestContextListener requestContextListener = new RequestContextListener();
		servletContext.addListener(requestContextListener);

		IntrospectorCleanupListener introspectorCleanupListener = new IntrospectorCleanupListener();
		servletContext.addListener(introspectorCleanupListener);

		// servletContext.setInitParameter("contextConfigLocation",
		// "classpath:application-config.xml");
		// servletContext.setInitParameter("defaultHtmlEscape", "true");

		// Creates a new instance that will instantiate the
		// ContextLoaderListener with the specified classes.
		super.onStartup(servletContext);

	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {
		registration.setInitParameter("defaultHtmlEscape", "true");
		// registration.setInitParameter("spring.profiles.active", "default");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {};
	}

	@Override
	protected String[] getServletMappings() {

		/**
		 * The /* on a servlet overrides all other servlets, including all
		 * servlets provided by the servletcontainer such as the default servlet
		 * and the JSP servlet.
		 */
		return new String[] { "/*" };
	}

	@Override
	protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {

		DispatcherServlet servlet = new DispatcherServlet(servletAppContext);
		servlet.setThrowExceptionIfNoHandlerFound(true);
		return servlet;
	}

}
// public class WebAppInitializer{}
