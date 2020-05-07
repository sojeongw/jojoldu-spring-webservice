package com.jojoldu.webservice.domain.posts;

import com.jojoldu.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor(access = AccessLevel.PROTECTED)  // 기본 생성자 자동 추가. 기본 생성자의 접근 권한을 protected로 제한한다. protected Posts() {}와 같은 효과다.
@Getter // 클래스 내 모든 필드의 getter 메소드를 자동 생성
@Entity // 실제 DB 테이블과 매칭될 클래스. 언더스코어로 이름을 매칭한다.
public class Posts extends BaseTimeEntity {

    /* 웬만하면 Entity의 PK는 Long 타입의 Auto_increment를 추천합니다.
    (MySQL 기준으로 이렇게 하면 bigint 타입이 됩니다.)
    주민등록번호와 같은 비지니스 상 유니크 키나, 여러 키를 조합한 복합키로 PK를 잡을 경우, 난감한 상황이 종종 발생합니다.
    (1) FK를 맺을때 다른 테이블에서 복합키 전부를 갖고 있거나, 중간 테이블을 하나 더 둬야하는 상황이 발생합니다.
    (2) 인덱스에 좋은 영향을 끼치지 못합니다.
    (3) 유니크한 조건이 변경될 경우 PK 전체를 수정해야하는 일이 발생합니다.
    주민등록번호, 복합키 등은 유니크 키로 별도로 추가하시는것을 추천드립니다. */

    @Id // 해당 테이블의 PK 필드
    @GeneratedValue // PK 생성 규칙
    private Long id;

    // 필드를 테이블의 컬럼으로 지정
    @Column(length = 500, nullable = false) // 기본은 varchar(255)지만 사이즈을 늘리거나 타입을 TEXT로 변경하고 싶을 때 옵션을 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 생성자와 빌더 모두 생성 시점에 값을 채워주지만 생성자의 경우실 실제로 코드를 실행하기 전까지는 지금 채워야할 필드가 무엇인지 명확하게 지정할 수 없다.
    // 빌더 패턴을 쓰면 어떤 값을 채워야 하는지 명확하게 인지할 수 있다.
    @Builder    // 해당 클래스의 빌더 패턴 클래스 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함한다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
