
package serg.servlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import serg.config.ApplicationConfig;
import serg.config.SpringWebConfig;


public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    @Override
    protected Class<?>[] getServletConfigClasses() {
	return new Class[] { SpringWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
	return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
	return new Class[] { ApplicationConfig.class };
    }
}
