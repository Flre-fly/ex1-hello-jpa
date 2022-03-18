package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    //연관관계 주인이 product라는 의미임
    //OneToMany는 왜 .. JoinColumn을 안쓰지
    @OneToMany(mappedBy = "product")
    private List<MemberProduct> memberProducts = new ArrayList<>();

    private String name;
}
