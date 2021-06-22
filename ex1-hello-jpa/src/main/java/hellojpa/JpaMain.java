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
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(1)      // 페이징 1번부터
                    .setMaxResults(10)      // 10번까지 가져오라는 것
                    .getResultList();

            for (Member member : result) {
                System.out.println("member.getName() = " + member.getName());
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
