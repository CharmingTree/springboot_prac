package jzero.config.autoconfig;

import jzero.config.ConditionalMyOnClass;
import jzero.config.MyAutoConfigration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@Slf4j
@MyAutoConfigration
//@ConditionalMyOnClass("")
@ConditionalMyOnClass("org.apache.catalina.startup.Tomcat")
public class TomcatWebServerConfig {

    @Bean("tomcatWebServerFactory")
    @ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {
        log.info("created tomcat");
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setPort(8776);
        return factory;
    }

}
