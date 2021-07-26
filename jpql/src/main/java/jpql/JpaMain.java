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
            Team teamA = new Team();
            teamA.setName("팀A");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("팀B");
            em.persist(teamB);


            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(20);
            member1.setTeam(teamA);
            member1.setType(MemberType.ADMIN);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setTeam(teamA);
            member2.setAge(10);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setTeam(teamB);
            member3.setAge(10);
            em.persist(member3);

//            em.flush();
//            em.clear();

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
//            String query = "select m From Team t join t.members m";

//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();

//            System.out.println("result = " + result);

//            for (Integer s : resultList) {
//                System.out.println("s = " + s);
//            }

            
            /* 페치 조인 */
//            String query = "select m From Member m join fetch m.team";
//
//            List<Member> result = em.createQuery(query, Member.class)
//                    .getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());
//                // 회원1, 팀A (SQL)
//                // 회원2, 팀A (1차 캐시)
//                // 회원3, 팀B (SQL)
//
//                // 회원 100명 -> N + 1 문제 발생
//            }
            
            /* 컬렉션 페치 조인 */
            // 일대다 페치 조인시 데이터가 중복될 수 있다.
            // 쿼리에 distinct를 넣어도 중복제거가 되지 않을 수 있다.
            // distinct가 추가로 어플리케이션에서 중복 제거 시도
            // 같은 식별자를 가진 Team 엔티티 제거
//            String query = "select m From Team t";
//
//            List<Team> result = em.createQuery(query, Team.class)
//                    .setFirstResult(0)
//                    .setMaxResults(2)
//                    .getResultList();
//
//            System.out.println("result.size = " + result.size());
//
//            for (Team team : result) {
//                System.out.println("member = " + team.getName() + " | member = " + team.getMembers().size());
//                for (Member member : team.getMembers()) {
//                    System.out.println("-> member = " + member);
//                }
//            }

//            String query = "select m From Member m where m.team = :team";
//
//            List<Member> result = em.createQuery(query, Member.class)
//                    .setParameter("team", teamA)
//                    .getResultList();
//
//            System.out.println("findMember = " + findMember);
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

            /* 네임드 쿼리 */
//            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
//                    .setParameter("username", "회원1")
//                    .getResultList();
//
//            for (Member member : resultList) {
//                System.out.println("member = " + member);
//            }

            /* 벌크 연산 */
            // flush 호출 -> commit, query, 강제 호출(flush)
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            System.out.println("resultCount = " + resultCount);

            // 벌크 연산 후 DB에는 쿼리가 날라가 반영이 되어있지만
            // 영속성 컨텍스트에는 반영이 되지 않았다.
            // 따라서 영속성 컨텍스트를 초기화 해주어야 한다.
            System.out.println("member1.getAge() = " + member1.getAge());
            System.out.println("member2.getAge() = " + member2.getAge());
            System.out.println("member3.getAge() = " + member3.getAge());

            em.clear();

            Member findMember2 = em.find(Member.class, member2.getId());

            System.out.println("findMember2 = " + findMember2.getAge());


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
