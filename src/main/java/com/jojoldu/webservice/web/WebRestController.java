package com.jojoldu.webservice.web;

import com.jojoldu.webservice.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponseBody를 모든 메소드에 적용해준다.
@AllArgsConstructor
public class WebRestController {

    private PostsRepository postsRepository;    // @Autowired 대신 생성자로 주입받는 것을 권장한다. 생성자는 @AllAlrgsConstructor가 만들어준다.

    @GetMapping("/")    // @GetMapping은 이전으로 보면 @RequestMapping(value="/", method = RequestMethod.GET)과 동일하다.
    public String main() {
        return "main";  // handlebars-spring-boot-starter 덕분에 컨트롤러에서 문자열을 반환할때 앞의 path와 뒤의 파일 확장자는 자동으로 지정된다. 즉, main.hbs가 로딩된다.
    }

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
