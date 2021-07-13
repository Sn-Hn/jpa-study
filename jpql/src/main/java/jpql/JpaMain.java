package jpql;

import javax.persistence.*;
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
            /* jpql */
            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);
            em.persist(member);

//            TypedQuery<Member> query1 = em.createQuery("Select m from Member m", Member.class);
//            TypedQuery<String> query2 = em.createQuery("Select m.username from Member m", String.class);
//            Query query3 = em.createQuery("Select m.username, m.age from Member m");

            // 결과가 없으면 빈 리스트 반환
//            List<Member> resultList = query1.getResultList();
            
            // 결과가 없으면 javax.persistence.NoResultException 에러
            // 결과가 둘 이상이면 javax.persistence.NonUniqueResultException
            // Spring Data JPA -> 결과가 없으면 Optional로 반환
//            String singleResult = query2.getSingleResult();

//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
//
//            System.out.println("singleResult = " + singleResult);

            Member result = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();

            System.out.println("result = " + result.getAge());

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
