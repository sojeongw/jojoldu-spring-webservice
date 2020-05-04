package com.jojoldu.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        // 이후 테스트에 영향을 끼치지 않기 위해 repository를 비우는 코드
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글_저장_불러오기() {
        // given: 테스트 기반 환경을 구축하는 단계. 여기선 @builder의 사용법도 같이 확인한다.
        postsRepository.save(Posts.builder()
            .title("테스트 게시글")
            .content("테스트 본문")
            .author("dodeon")
            .build()
        );

        // when: 테스트 하고자 하는 행위 선언. 여기선 Posts가 DB에 insert 잘 되는지 확인한다.
        List<Posts> postsList = postsRepository.findAll();

        // then: 테스트 겨로가 검증. 실제로 DB에 insert 되었는지 확인하기 위해 조회 후 입력된 값을 확인한다.
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }
}