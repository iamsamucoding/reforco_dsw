
package br.edu.ifsp.regescweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@ComponentScan(basePackages = {"br.edu.ifsp.regescweb.controllers"})
public class AppWebConfig {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        
        return resolver;
    }
}



