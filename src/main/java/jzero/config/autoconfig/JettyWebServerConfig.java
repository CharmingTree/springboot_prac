package jzero.config.autoconfig;


import jzero.config.ConditionalMyOnClass;
import jzero.config.MyAutoConfigration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;

@MyAutoConfigration
//@ConditionalMyOnClass("org.eclipse.jetty.server.Server")
@ConditionalMyOnClass("")
public class JettyWebServerConfig {
    @Bean("jettyWebServerFactory")
    //@ConditionalOnMissingBean
    public ServletWebServerFactory servletWebServerFactory() {

        JettyServletWebServerFactory jettyServletWebServerFactory = new JettyServletWebServerFactory();
        jettyServletWebServerFactory.setPort(8776);
        return jettyServletWebServerFactory;
    }
}
