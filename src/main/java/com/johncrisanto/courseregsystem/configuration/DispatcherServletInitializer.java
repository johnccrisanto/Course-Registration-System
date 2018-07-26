package com.johncrisanto.courseregsystem.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Return an array of configuration classes
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
    }

    // Map the dispatcher servlet to the root of the app
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
