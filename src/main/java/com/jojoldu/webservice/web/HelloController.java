package com.jojoldu.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
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
}
