package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {

        /* EntityManagerFactory는 시작 시 하나만 생성해야 한다. */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        /* JPA를 시작하기 위해 transaction 시작 */
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /* 등록 */
//            Member member = new Member();
//
//            member.setId(2L);
//            member.setName("HelloB");
//            em.persist(member);

            /* 조회 */
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

            /* 삭제 */
//            em.remove(findMember);

            /* 수정 */
//            findMember.setName("HelloJPA");

            /* JPQL */
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)      // 페이징 1번부터
//                    .setMaxResults(10)      // 10번까지 가져오라는 것
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member.getName() = " + member.getName());
//            }

            /* 영속성 컨텍스트 */
            // 비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");

            // 영속
//            System.out.println("=== BEFORE ===");
//            em.persist(member);
            // 준영속
//            em.detach(member);
//            System.out.println("=== AFTER ===");
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);

            // 삭제
//            em.remove(101L);

            /* 동일성 보장 */
            // 1차 캐시로 반복되는 읽기 등급의 트랜잭션 격리 수준을 DB가 아닌 애플리케이션 차원에서 제공
            // 즉, findMember1을 DB에서 꺼내온 후 findMember2는 1차 캐시에서 가져온다.
            // 따라서 findMember1과 findMember2는 동일성을 보장한다.
//            System.out.println("result = " + (findMember1 == findMember2));
            
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getName() = " + findMember.getName());

//            Member memberA = new Member(150L, "A");
//            Member memberB = new Member(160L, "B");

            /* 쓰기 지연 */
//            System.out.println("=== AFTER ===");
//            em.persist(memberA);
//            em.persist(memberB);
//            System.out.println("=== BEFORE ===");

            /* 변경 감지 */
            Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");
            System.out.println("================");
            member.setName("AAAAA");
            System.out.println("================");
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
