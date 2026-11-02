package me.swhwang.springApplication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.swhwang.springApplication.dao.Article;
import me.swhwang.springApplication.dto.ArticleCreationRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class BlogApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("addArticle: 블로그 글 추가에 성공한다.")
    @Test
    public void addArticle() throws Exception {
        // 준비 given: 저장할 데이터를 준비, 요청 URL 준비
        String title = "JUnit 테스트를 통한 블로그 글 생성";
        String content = "수업 종료 10분전, 이 테스트를 성공 후 점심 식사한다!!!";
        String url = "/api/articles";
        ArticleCreationRequest req = new ArticleCreationRequest(title, content);

        String articleStr = objectMapper.writeValueAsString(req);

        // 실행 when
        ResultActions result = mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(articleStr));

        // 검증 then
        List<Article> articles = blogRepository.findAll();
        assertThat(articles.size()).isEqualTo(1);
        Article article = articles.get(0);
        assertThat(articles.get(0).getTitle()).isEqualTo(title);
        assertThat(articles.get(0).getContent()).isEqualTo(content);
    }
}