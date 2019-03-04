package com.zfsoft.zftal;

import com.zfsoft.zftal.service.CityService;
import com.zfsoft.zftal.service.ServiceFacade;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.zfsoft.zftal.mapper") // 定义了在哪里扫描mapper文件
public class DemoApplication extends SpringBootServletInitializer implements ApplicationRunner {

//    @Autowired
//    private ServiceFacade userService;
    @Autowired
    private CityService cityService;

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
//        userService.doService("insert");
        System.out.println("hello world!");
        System.out.println(cityService.getByProvinceId(1L));
    }
}

