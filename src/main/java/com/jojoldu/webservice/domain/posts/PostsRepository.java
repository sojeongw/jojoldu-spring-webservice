package com.jojoldu.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {   // JpaRepository<Entity클래스, PK타입> 을 상속한다. 이렇게 하면 @Repository를 추가할 필요도 없다.

}
