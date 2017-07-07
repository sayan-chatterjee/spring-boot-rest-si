//package com.pwc.demo;
//
//import java.util.concurrent.TimeUnit;
//
//import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
//import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//
//
//@Configuration
//@ComponentScan({"com.pwc"}) // search the com.company package for @Component classes
//@ImportResource("classpath:config/integration.xml") // XML with DataSource bean
//public class WebAppConfig {
//	
//    @Bean
//    public EmbeddedServletContainerFactory servletContainer() {
//        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
//        factory.setPort(8080);
//        factory.setSessionTimeout(10, TimeUnit.MINUTES);
//        return factory;
//    } 
//}
