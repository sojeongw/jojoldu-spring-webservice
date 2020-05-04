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

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
