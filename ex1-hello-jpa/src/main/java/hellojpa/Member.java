package hellojpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
/* @Table을 선언하지 않으면 기본값으로 클래스명을 테이블명으로 인식 */
//@Table(name = "USER")
public class Member {

    @Id
    private Long id;

    /* @Column 선언하지 않으면 기본값으로 변수명을 컬럼명으로 인식 */
//    @Column(name = "username")
    private String name;
    private int age;

    // 동적으로 객체를 생성해야하기 때문에 기본 생성자가 있어야 한다.
    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
