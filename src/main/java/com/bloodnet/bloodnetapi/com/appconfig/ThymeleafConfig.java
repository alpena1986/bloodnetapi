package com.bloodnet.bloodnetapi.com.appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

@Configuration
public class ThymeleafConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware {
    
    private ApplicationContext applicationContext;
    
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    @Bean
    public ViewResolver viewResolver() {
        
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        
        //http header field
        resolver.setCharacterEncoding("UTF-8");
        resolver.setContentType("text/html");
        return resolver;
    }
    
    @Bean
    public TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setEnableSpringELCompiler(true);
        engine.setTemplateResolver(templateResolver());
        return engine;
    }
    
    private ITemplateResolver templateResolver() {
        
        //The first difference with the Thymeleaf 2 configuration is that 
        //now the recommended template resolver for Spring applications is SpringResourceTemplateResolver. 
        //It needs a reference to the Spring ApplicationContext so the configuration bean has to implement the ApplicationContextAware interface.
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/thymeleaf/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        
        //テンプレートファイルのエンコーディングを指定する。
        resolver.setCharacterEncoding("UTF-8");
        return resolver;
    }
    
}
