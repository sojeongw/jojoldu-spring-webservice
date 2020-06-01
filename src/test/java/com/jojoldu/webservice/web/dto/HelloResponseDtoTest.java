package com.jojoldu.webservice.web.dto;

import org.junit.Test;

/* jUnit의 assertThat 대신 assertj의 assertThat을 사용한다.
* CoreMatchers와 같은 추가적인 라이브러리가 필요하지 않고
* 자동완성이 좀 더 확실하게 지원되기 때문이다. */
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto helloResponseDto = new HelloResponseDto(name, amount);

        // then
        assertThat(helloResponseDto.getName()).isEqualTo(name);
        assertThat(helloResponseDto.getAmount()).isEqualTo(amount);
    }
}