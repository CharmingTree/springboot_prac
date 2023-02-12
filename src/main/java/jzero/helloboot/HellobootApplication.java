package jzero.helloboot;

import jzero.config.MySpringBootAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

//@Configuration
//@ComponentScan
//@SpringBootApplication
@Slf4j
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

	@Bean
	ApplicationRunner applicationRunner(Environment env) {
		return args -> {

		};
	}

	public static void main(String[] args) {

		log.info("adfdf");

		//MySpringApplication.run(HellobootApplication.class, args);

		SpringApplication.run(HellobootApplication.class, args);

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