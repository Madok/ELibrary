package com.zpo.elibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zpo.elibrary.configuration.DBConfiguration;
import com.zpo.elibrary.configuration.WebSecurityConfig;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zpo.elibrary", "com.zpo.com.zpo.elibrary.db.repository"})
public class AppElibrary extends WebMvcConfigurerAdapter {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS =
        {"classpath:/META-INF/", "classpath:/templates/", "classpath:/static/"};

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/static/**/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);

    }

    public static void main(final String[] args) throws Exception {

        SpringApplication.run(new Object[] {AppElibrary.class, DBConfiguration.class, WebSecurityConfig.class}, args);
    }
}
