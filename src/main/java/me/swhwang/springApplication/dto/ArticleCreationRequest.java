package me.swhwang.springApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.swhwang.springApplication.dao.Article;


@Getter
@AllArgsConstructor
public class ArticleCreationRequest {
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
