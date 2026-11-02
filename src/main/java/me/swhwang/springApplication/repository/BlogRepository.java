package me.swhwang.springApplication.repository;

import me.swhwang.springApplication.dao.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
    // findById(), findAll(), save(), saveAll(), deleteById(), deleteAll()

}
