package jzero.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloApiTest {

//    @Test
//    void helloApi() {
//        TestRestTemplate rest = new TestRestTemplate();
//
//        ResponseEntity<String> result =  rest.getForEntity("http://localhost:8776/hello?name={name}", String.class, "Spring");
//
//        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        assertThat(result.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
//
//        assertThat(result.getBody()).isEqualTo("hello Spring");
//    }


    @Test
    void failHelloApi() {
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> result =  rest.getForEntity("http://localhost:8776/hello?name=", String.class);

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);

    }

}
