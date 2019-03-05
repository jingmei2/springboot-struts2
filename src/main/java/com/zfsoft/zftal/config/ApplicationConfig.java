package com.zfsoft.zftal.config;/**
 * Created by  Administrator on 2019-03-05 04:37 PM
 */

import com.zfsoft.zftal.filter.WeChatLoginFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * @program: springboot-struts2
 *
 * @description: springboot 替换Struts2配置文件
 *
 * web.xml文件中定义了filter, struts2等等一堆filter, 这时我们需要做的一件事是在springboot中使我们的filter, struts2 能正常work。
 * 这样就不需要我们改变项目中已经定义好的大量的action、controller层代码
 *
 * @author: Majing
 *
 * @create: 2019-03-05 16:37
 **/
//声明当前类为一个配置类
@Configuration
//自动扫描包路径
@ComponentScan({"com.zfsoft.zftal.**"})
//引入之前已经存在的配置文件
@ImportResource(locations = {
//        "classpath:applicationContext-configuration.xml",
//        "classpath:applicationContext-orm.xml",
//        "classpath:applicationContext-business.xml",
//        "classpath:ApplicationContext-RabbitMQ.xml",
//        "classpath:applicationContext-security-authorization.xml",
})
public class ApplicationConfig {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
    private WeChatLoginFilter weChatLoginFilter = new WeChatLoginFilter();
    private StrutsPrepareAndExecuteFilter strutsPrepareAndExecuteFilter = new StrutsPrepareAndExecuteFilter(); //springboot启动时初始化struts2拦截器

    @Bean
    @Order(1)
    public FilterRegistrationBean loginFilter() {
        /*
         * <filter>
         * <filter-name>LoginFilter</filter-name>
         * <filter-class>com.demo.servlet.LoginFilter</filter-class>
         * </filter>
         * <filter-mapping>
         * <filter-name>LoginFilter</filter-name>
         * <url-pattern>/login/*</url-pattern>
         * <url-pattern>/login.html</url-pattern>
         * </filter-mapping>
         */
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new WeChatLoginFilter());//注册拦截filter
        registrationBean.addUrlPatterns("/*", "/login.html");//拦截路径
        return registrationBean;
    }
    @Bean
    @Order(2)
    public FilterRegistrationBean strutsPrepareAndExecuteFilter() {
        /*
         * <filter>
         * <filter-name>struts2</filter-name>
         * <filter-class>org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter</filter-class>
         * </filter>
         * <filter-mapping>
         * <filter-name>struts2</filter-name>
         * <url-pattern>/*</url-pattern>
         * </filter-mapping>
         * <filter-mapping>
         * <filter-name>struts2</filter-name>
         * <dispatcher>FORWARD</dispatcher>
         * </filter-mapping>
         */
        log.debug("Instantiating StrutsPrepareAndExecuteFilter");
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(strutsPrepareAndExecuteFilter);//注册Struts2拦截器
        registrationBean.setName("StrutsPrepareAndExecuteFilter");
        registrationBean.addUrlPatterns("/*");//默认拦截所有请求
        return registrationBean;
    }
}
