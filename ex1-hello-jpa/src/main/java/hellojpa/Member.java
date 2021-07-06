package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
/* @Table을 선언하지 않으면 기본값으로 클래스명을 테이블명으로 인식 */
//@Table(name = "USER")
//@SequenceGenerator(name = "MEMBER_SEQ_GENERATOR", sequenceName = "MEMBER_SEQ",
//initialValue = 1, allocationSize = 50)
//@TableGenerator(
//        name = "MEMBER_SEQ_GENERATOR",
//        table = "MY_SEQUENCES",
//        pkColumnValue = "MEMBER_SEQ", allocationSize = 1
//)
public class Member extends BaseEntity {

//    @GeneratedValue(strategy = GenerationType.IDENTITY /*, generator = "MEMBER_SEQ_GENERATOR"*/)
    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name ="USERNAME")
    private String username;

    // 기간 Period
    @Embedded
    private Period workPeriod;

    // 주소
    @Embedded
    private Address homeAddress;

//    @Embedded
//    @AttributeOverrides({
//            @AttributeOverride(name="city",
//                    column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name="street",
//                    column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name="zipcode",
//                    column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn
//    private Team team;
//
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    // 동적으로 객체를 생성해야하기 때문에 기본 생성자가 있어야 한다.
    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }

//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }


//    @Override
//    public String toString() {
//        return "Member{" +
//                "id=" + id +
//                ", username='" + username + '\'' +
//                ", team=" + team +
//                '}';
//    }
//
//
//    public Team getTeam() {
//        return team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }


    public Period getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(Period workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }
}
