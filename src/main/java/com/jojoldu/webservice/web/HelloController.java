package com.jojoldu.webservice.web;

import com.jojoldu.webservice.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON을 반환하는 컨트롤러로 만들어준다.
// 예전에 @ResponseBody를 각 메서드마다 선언했던 것을 한 번에 사용할 수 있게 해준다.
@RestController
public class HelloController {
    // 과거에는 @RequestMapping(method = RequestMethod.GET)으로 표현했던 부분이다.
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        /* @RequestParam
         * 외부에서 API로 넘긴 파라미터를 가져오는 애너테이션이다.
         * name이란 이름으로 넘긴 파라미터를 메서드 파라미터인 String name에 저장한다. */
        return new HelloResponseDto(name, amount);
    }
}
