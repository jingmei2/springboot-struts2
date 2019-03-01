package com.zfsoft.zftal;

import com.zfsoft.zftal.service.ServiceFacade;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer implements ApplicationRunner {

    @Autowired
    private ServiceFacade userService;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
        registrationBean.setFilter(struts);
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.doService("insert");
    }
}

