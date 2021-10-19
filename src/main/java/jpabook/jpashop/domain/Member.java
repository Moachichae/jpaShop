package jpabook.jpashop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장타입이다.
    private Address address;

    @OneToMany(mappedBy = "member") //나는 거울
    private List<Order> orders = new ArrayList<>(); // 하이버네이트의 best 선택


}
