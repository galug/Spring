package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity// jpa를 사용하는 객체라고 인식
//@Table(name="USER")
public class Member extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name="USERNAME", nullable = false) //column name 을 설정 가능하다.
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "TEAM_ID")
    private Team team;

    // 주소
    @Embedded
    private Address homeAddress;

    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD",joinColumns =
        @JoinColumn(name = "MEMBER_ID"))
    @Column(name ="FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "ADDRESS",joinColumns =
        @JoinColumn(name = "MEMBER_ID")
    )
    private List<Address> addressList = new ArrayList<>();

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
