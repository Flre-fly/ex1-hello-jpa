package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(mappedBy = "products")
    private List<Member> member = new ArrayList<>();

    private String name;
}
