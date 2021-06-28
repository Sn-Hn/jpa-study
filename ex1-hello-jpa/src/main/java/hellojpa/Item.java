package hellojpa;

import javax.persistence.*;

// JPA 기본 전략 자체가 싱글 테이블에 전부 들어가게 되어 있다.
@Entity
//@Inheritance(strategy = InheritanceType.JOINED)     // 싱글테이블이 아닌 슈퍼타입 서브타입 모델로 구현
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)       // 성능상 제일 좋음.  @Inheritance를 선언하지 않아도 기본 전략으로 SINGLE_TABLE이 선택된다.
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn      // 싱글테이블 전략에서는 생략해도 DType이 생성된다.  TABLE_PER_CLASS 전략에서는 써도 사용하지 않는다.
public abstract class Item {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private int price;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
