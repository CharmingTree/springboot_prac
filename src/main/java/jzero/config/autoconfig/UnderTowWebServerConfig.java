package jzero.config.autoconfig;


import jzero.config.ConditionalMyOnClass;
import jzero.config.MyAutoConfigration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;


@MyAutoConfigration
@ConditionalMyOnClass("org.springframework.boot.web.embedded.undertow.UndertowWebServer")
public class UnderTowWebServerConfig {

    @Bean("underTowWebServerFactory")
    //@ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.setPort(8776);
        return factory;
    }
}
