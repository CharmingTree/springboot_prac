package jzero.helloboot;


//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

//@RestControll
//er
@RequestMapping // dipatcher 가 클래스 레벨 수준에서 찾게함
@RestController // Controller 어노테이션 과 ResponseBody 두개가 구성되어있음. == Controller + ResponseBody
public class HelloController { //implements ApplicationContextAware

    //private ApplicationContext applicationContext;
    private final HelloService helloService;

//    public HelloController(HelloService helloService, ApplicationContext applicationContext) {
//        this.helloService = helloService;
//        this.applicationContext = applicationContext;
//
//        System.out.println(applicationContext);
//    }

    public HelloController(HelloService helloService) {
        this.helloService = helloService;

        System.out.println("hello Service di : " + this.helloService);
    }

    @GetMapping("/hello")
    //@ResponseBody // 응답을 Body에 생략되면 리턴된 스트링으로 뷰를 찾음.
    // GetMapping == @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String name) {

        if (name == null || name.isEmpty()) throw new IllegalArgumentException();

        return helloService.sayHello(Objects.requireNonNull(name));
        // 리턴된 스트링으로된 이름으된 뷰를 찾음
        // 리턴값을 바디에 넣어서 응답하게 해야함.
    }

//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        System.out.println(applicationContext);
//        this.applicationContext = applicationContext;
//    }
}
