package hellojpa;

import javax.persistence.*;

@Entity
public class Child {
    @Id
    @GeneratedValue
    @Column(name = "child_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;


    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
