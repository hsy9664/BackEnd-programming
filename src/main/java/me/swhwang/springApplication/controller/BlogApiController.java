package me.swhwang.springApplication.controller;

import lombok.RequiredArgsConstructor;
import me.swhwang.springApplication.dao.Article;
import me.swhwang.springApplication.dto.ArticleCreationRequest;
import me.swhwang.springApplication.dto.ArticleResponse;
import me.swhwang.springApplication.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addAricle(@RequestBody ArticleCreationRequest articleCreationRequest) {
        // 서비스에게 블로그 글 등록을 의뢰
        Article savedArticle = blogService.save(articleCreationRequest);
        // 성공했다면 ResponseEntity를 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> getAllAriticles() {
    List<ArticleResponse> articleResponseList = blogService.findAll().stream().map(ArticleResponse::new).toList();
    return ResponseEntity.ok().body(articleResponseList);
    }
}
