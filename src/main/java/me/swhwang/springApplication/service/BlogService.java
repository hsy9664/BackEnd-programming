package me.swhwang.springApplication.service;

import lombok.RequiredArgsConstructor;
import me.swhwang.springApplication.dao.Article;
import me.swhwang.springApplication.dto.ArticleCreationRequest;
import me.swhwang.springApplication.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    public final BlogRepository blogRepository;

    public Article save(ArticleCreationRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }
}
