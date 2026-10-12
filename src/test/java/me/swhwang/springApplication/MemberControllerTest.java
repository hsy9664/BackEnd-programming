package me.swhwang.springApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void deleteAll() {
        memberRepository.deleteAll();
    }

    @Test
    public void getAllMembers() throws Exception {
        // given (준비)
        // 한 명의 회원을 DB 테이블에 저장함으로써 등록
        final String url = "/api/members";
        Member savedMember = memberRepository.save(new Member("홍길동"));

        // when (실행)
        // 회원 리스트 생성
        final ResultActions result = mockMvc.perform(get(url)
                .accept(MediaType.APPLICATION_JSON));

        // then (검증)
        // 회원 리스트 요청에 의해서 전달받은 데이터가 준비 단계에서 저장된 회원 정보와 동일한지 검증
        result
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));


    }
}