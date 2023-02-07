package jzero.helloboot;

import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class MySpringApplication {

    public static void run(Class<?> applicationClass, String... args) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext() {
            @Override
            protected void onRefresh() {
                super.onRefresh();

                ServletWebServerFactory serverFactory = this.getBean(ServletWebServerFactory.class);
                DispatcherServlet dispatcherServlet = this.getBean(DispatcherServlet.class);
                //dispatcherServlet.setApplicationContext(this);
                WebServer webServer = serverFactory.getWebServer(servletContext -> {

                    servletContext.addServlet("dispatcherServlet", dispatcherServlet)
                            .addMapping("/*"); // /hello 으로 요청이 오면 해당 서비스로 맵핑해라.
                });

                // tocat server execute

                webServer.start();

            }
        };
        // spring 컨테이너가 빈 생성(초기화)
        //applicationContext.registerBean(HelloController.class);
        //applicationContext.registerBean(SimpleHelloService.class);

        applicationContext.register(applicationClass);
        applicationContext.refresh();
    }
}
