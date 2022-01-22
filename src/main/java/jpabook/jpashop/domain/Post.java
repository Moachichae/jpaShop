package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Post {
    @Id
    @GeneratedValue
    private long postNo;
    @Column
    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;
}
