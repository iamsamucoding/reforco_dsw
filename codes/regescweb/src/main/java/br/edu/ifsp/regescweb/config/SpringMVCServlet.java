
package br.edu.ifsp.regescweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class SpringMVCServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Usa outras classes de configuração de views, banco de dados, etc, no Spring MVC
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppWebConfig.class};
    }


    // Define as URLs a partir das quais todas as Servlets/Controllers serão mapeadas
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
