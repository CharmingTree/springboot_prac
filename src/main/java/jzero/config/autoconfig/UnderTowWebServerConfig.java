package jzero.config.autoconfig;


import jzero.config.ConditionalMyOnClass;
import jzero.config.MyAutoConfigration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


@MyAutoConfigration
@ConditionalMyOnClass("org.springframework.boot.web.embedded.undertow.UndertowWebServer")
public class UnderTowWebServerConfig {

    @Value("${contextPath}")
    String contextPath;

    @Value("${server.port}")
    String port;

    @Bean("underTowWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        //factory.setContextPath(environment.getProperty("contextPath"));
        factory.setContextPath(this.contextPath);
        factory.setPort(Integer.valueOf(port));
        return factory;
    }
}
