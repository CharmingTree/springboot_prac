package jzero.helloboot;

import jzero.config.MySpringBootAnnotation;

//@Configuration
//@ComponentScan
//@SpringBootApplication
@MySpringBootAnnotation
public class HellobootApplication {

//	@Bean
//	public HelloController helloController(HelloService helloService) {
//		return new HelloController(helloService);
//	}
//
//	@Bean
//	public HelloService helloService() {
//		return new SimpleHelloService();
//	}


	public static void main(String[] args) {


		MySpringApplication.run(HellobootApplication.class, args);


	}



}



//@SpringBootApplication
//public class HellobootApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(HellobootApplication.class, args);
//	}
//
//}