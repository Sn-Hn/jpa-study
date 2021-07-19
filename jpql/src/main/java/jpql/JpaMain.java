package jpql;

import javax.persistence.*;
import java.util.Collection;
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
            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setAge(20);
            member1.setTeam(team);
            member1.setType(MemberType.ADMIN);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(team);
            member2.setAge(10);
            em.persist(member2);

            em.flush();
            em.clear();

            /* 페이징 */
//            for (int i = 0; i < 100; i++) {
//                Member member = new Member();
//                member.setUsername("member" + i);
//                member.setAge(i);
//                em.persist(member);
//            }

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

//            List<MemberDTO> resultList = em.createQuery("select new jpql.MemberDTO(m.username, m.age) from Member m", MemberDTO.class)
//                    .getResultList();
//
//            MemberDTO result = resultList.get(0);
//            System.out.println("username = " + result.getUsername());
//            System.out.println("age = " + result.getAge());

//            Member findMember = result.get(0);
//            findMember.setAge(20);
            
            /* 페이징 */
//            List<Member> resultList = em.createQuery("select m from Member m order by m.age desc", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//
//            System.out.println("resultList.size() = " + resultList.size());
//            for (Member member1 : resultList) {
//                System.out.println("member1 = " + member1);
//            }
            
            /* 조인 */
//            String query = "select m from Member m left join Team t on m.username = t.name";
//            List<Member> resultList = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            System.out.println("resultList.size() = " + resultList.size());

            /* 서브쿼리 */
            // FROM 절에서는 서브쿼리가 지원되지 않는다.
//            String query = "select (select avg(m1.age) From Member m1) as avgAge from Member m left join Team t on m.username = t.name";
//            String query = "select mm.age, mm.username from (select m.age from Member m) as mm";        지원 X
//            List<Member> resultList = em.createQuery(query, Member.class)
//                    .getResultList();

            /* JPQL 타입 표현 */
//            String query = "select m.username, 'HELLO', true from Member m " +
//                           "where m.type = :userType";
//            List<Object[]> resultList = em.createQuery(query)
//                    .setParameter("userType", MemberType.ADMIN)
//                    .getResultList();
//
//            for (Object[] objects : resultList) {
//                System.out.println("objects = " + objects[0]);
//                System.out.println("objects = " + objects[1]);
//                System.out.println("objects = " + objects[2]);
//            }

            /* 조건식 */
            // case
//            String query =
//                    "select " +
//                            "case when m.age <= 10 then '학생요금' " +
//                            "     when m.age >= 60 then '경로요금' " +
//                            "     else '일반요금' " +
//                            "end " +
//                    "from Member m";

            // coalesce
//            String query = "select coalesce(m.username, '이름 없는 회원') from Member m ";

            // nullif
//            String query = "select nullif(m.username, '관리자') as username from Member m";
//
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }

            // size -> 컬렉션 개수
            // index -> 값 타입 컬렉션의 위치값을 구함
//            String query = "select size(t.members) from Team t";
//
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }

            /* 사용자 정의 함수 */
//            String query = "select function('group_concat', m.username) from Member m";
//            String query = "select group_concat(m.username) from Member m";
//
//            List<String> resultList = em.createQuery(query, String.class)
//                    .getResultList();
//
//            for (String s : resultList) {
//                System.out.println("s = " + s);
//            }

            /* 단일 값 연관 경로 (묵시적 내부 조인 발생) */
//            String query = "select m.team from Member m";
            String query = "select m From Team t join t.members m";

            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();

            System.out.println("result = " + result);

//            for (Integer s : resultList) {
//                System.out.println("s = " + s);
//            }



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
