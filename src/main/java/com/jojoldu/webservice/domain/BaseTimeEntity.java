package com.jojoldu.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entity 클래스들이 BaseTimeEntity를 상속하면 createdDate, modifiedDate 등 필드들도 컬럼으로 인식하게 한다.
@EntityListeners(AuditingEntityListener.class)  // BaseTimeEntity에 Auditing 기능을 포함시킨다.
public class BaseTimeEntity {

    /* 보통 Entity에는 해당 데이터의 생성시간과 수정시간을 포함시킵니다.
    언제 만들어졌는지, 언제 수정되었는지 등은 차후 유지보수에 있어 굉장히 중요한 정보이기 때문입니다.

    그렇다보니 매번 DB에 insert 하기 전, update 하기 전에 날짜 데이터를 등록/수정 하는 코드가 여기저기 들어가게 됩니다.
    이런 단순하고 반복적인 코드가 모든 테이블과 서비스 메소드에 포함되어야 한다고 생각하면 어마어마하게 귀찮고 코드가 더러워지겠죠?
    그래서 이 문제를 해결하기 위해 JPA Auditing를 사용하겠습니다.

    Java 8부터 LocalDate와 LocalDateTime이 등장했는데요.
    그간 Java의 기본 날짜 타입인 Date의 문제점을 제대로 고친 타입이라 Java 8일 경우 무조건 써야한다고 생각하시면 됩니다. */

    @CreatedDate    // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    private LocalDateTime modifiedDate;
}
