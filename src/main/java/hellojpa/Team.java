package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "team_id")
    private Long id;

    private String name;

    // 데이터베이스를 기준으로 Team과 Member는 어떤 값을 가지고 서로 연관관계를 인식하나요? Team의 Id입니다.
    // 따라서, 외래키로 매핑되는 대상이 Member 테이블의 Team Id가 되는 것입니다.
    @OneToMany
    @JoinColumn(name = "team_id")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }


}
