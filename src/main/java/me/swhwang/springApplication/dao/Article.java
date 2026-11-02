package me.swhwang.springApplication.dao;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;         // PK

    @Column(name = "title", nullable = false)
    private String title;    // NOT NULL

    @Column(name = "content", nullable = false)
    private String content;  // NOT NULL

    @Builder
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
