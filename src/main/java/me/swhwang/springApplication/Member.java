package me.swhwang.springApplication;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;
    @Column(name="name", nullable = false)
    @Setter(AccessLevel.PUBLIC)
    private String name;
    public Member(String name) {
        this.name = name;
    }
}
