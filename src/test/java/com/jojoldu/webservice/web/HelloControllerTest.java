package com.jojoldu.webservice.web;

import com.jojoldu.webservice.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/* 테스트를 진행할 때  JUnit에 내장된 실행자 외에 다른 실행자를 실행한다.
* 여기서는 SpringRunner 라는 실행자를 사용한다.
* 즉, 스프링 부슽 테스트와 JUnit 사이에 연결자 역할을 한다.
* */
@RunWith(SpringRunner.class)
/* Web(Spring MVC)에 집중할 수 있는 애너테이션이다.
* 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
* 하지만 @Service, @Component, @Repository는 쓸 수 없다.
* 여기서는 컨트롤러만 사요앟기 때문에 @WebMvcTest를 사용했다.
* */
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    // 빈 주입
    @Autowired
    /* 웹 API를 테스트할 때 사용하는 스프링 MVC 테스트의 시작점이다.
     이 클래스로 HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.*/
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        // MockMvc를 통해 /hello 주소로 HTTP GET 요청을 한다.
        mvc.perform(get("/hello"))
                // perform의 결과를 HTTP header의 status로 검증한다.
                .andExpect(status().isOk()) // 200인지 아닌지 확인한다.
                .andExpect(content().string(hello));    // 응답 본문의 내용을 검증한다.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name", name)
                // 요청 파라미터를 String만 허용하므로 숫자/날짜 등의 데이터도 String으로 변환한다.
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                // JSON 응답값을 필드별로 검증할 수 있는 메서드
                // $를 기준으로 필드명을 명시한다. 즉, $.name으로 name을 검증한다.
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));


    }
}