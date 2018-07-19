package fortesting.spring.config;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.XmlViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="fortesting")
public class DispatcherServletConfig extends WebMvcConfigurerAdapter {
    @Resource
    private ServletContext application;
    
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        org.springframework.core.io.Resource resource = new ServletContextResource(application, "/WEB-INF/views.xml");
        XmlViewResolver viewResolver = new XmlViewResolver();
        viewResolver.setLocation(resource);
        registry.viewResolver(viewResolver);
    }    
}