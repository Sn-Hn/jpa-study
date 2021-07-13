package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
//            Member member = em.find(Member.class, 150L);
//            member.setName("ZZZZZ");
//            System.out.println("================");
//            member.setName("AAAAA");
//            System.out.println("================");

//            Member member = new Member();
//            member.setId("ID_A");
//            member.setUsername("C");

//            System.out.println("=================");
//            System.out.println("member.getId() = " + member.getId());
//            em.persist(member);
//            System.out.println("member.getId() = " + member.getId());
//            System.out.println("=================");
            
            
            /* 연관관계 매핑 */
            // 저장
//            Member member = saveMember(em);

//            member.changeTeam(team);

//            Team team = new Team();
//            team.setName("TeamA");
//
//            team.getMembers().add(member);
//
//            em.persist(team);

//            team.getMembers().add(member);
//            team.addMember(member);

//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member.getId());

//            List<Member> members = findMember.getTeam().getMembers();
//
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }

//            Team findTeam = em.find(Team.class, team.getId());
//            List<Member> members = findTeam.getMembers();

//            System.out.println("============");
//            for (Member member1 : members) {
//                System.out.println("member1.getUsername() = " + member1.getUsername());
//            }
            /* #주의# toString 시 무한 루프에 걸릴 수 있다. */
//            System.out.println("findTeam = " + findTeam);
//            System.out.println("============");

            /* 고급 매핑 */
//            Movie movie = new Movie();
//            movie.setDirector("aaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과함께사라지다.");
//            movie.setPrice(10000);

//            em.persist(movie);

//            Item findItem = em.find(Item.class, movie.getId());
//            System.out.println("findMovie = " + findItem);

//            Member member = new Member();
//            member.setUsername("user1");
//            member.setCreatedBy("kim");
//            member.setCreatedDate(LocalDateTime.now());

//            em.persist(member);

            /* 프록시 */
//            Member member = em.find(Member.class, 1L);

//            printMember(member);
            
//            printMemberAndTeam(member);
            
//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//
//            em.persist(member1);

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);


//            em.flush();
//            em.clear();

//            Member findMember = em.find(Member.class, member1.getId());

//            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
//                    .getResultList();

//            System.out.println("findMember.getClass() = " + findMember.getTeam().getClass());
//
//            System.out.println("=======");
//            System.out.println(findMember.getTeam().getName());     // 초기화
//            System.out.println("=======");
//            Member m2 = em.getReference(Member.class, member2.getId());
//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.getId() = " + findMember.getId());
//            System.out.println("findMember.getUsername() = " + findMember.getUsername());

//            logic(m1, m2);

//            Member findMember = em.find(Member.class, member1.getId());
//            System.out.println("findMember.getClass() = " + findMember.getClass());

//            System.out.println("refMember == findMember e :  = " + (refMember == findMember));

//            em.detach(refMember);
//            em.clear();
//            em.close();

//            System.out.println("refMember.getUsername() = " + refMember.getUsername());
//            refMember.getUsername();
            // 프록시 객체 초기화 여부 확인
//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            // 프록시 강제 초기화
//            Hibernate.initialize(refMember);        // JPA 표준에는 강제 초기화 없음 -> 강제 호출 : refMember.getUsername()

            /* 영속성 전이 CASCADE */
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            em.persist(child1);
//            em.persist(child2);
//
//            em.flush();
//            em.clear();

//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(1);

//            em.remove(findParent);

//            findParent.getChildList().remove(0);

            /* 값 타입 */
//            Address address = new Address("city", "street", "10");
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(address);
//            em.persist(member1);

//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);

//            member1.getHomeAddress().setCity("newCity");

            // member1을 바꾸고 싶다면 객체를 재 생성해야 한다.
//            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
//            member1.setHomeAddress(newAddress);

            /* 값 타입 컬렉션 */
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("city1", "street", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddresseHistory().add(new AddressEntity("old1", "street", "zipcode"));
//            member.getAddresseHistory().add(new AddressEntity("old2", "street", "zipcode"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("================ START ================");
//            Member findMember = em.find(Member.class, member.getId());

//            List<Address> addresseHistory = findMember.getAddresseHistory();
//            for (Address address : addresseHistory) {
//                System.out.println("address.getCity() = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // homeCity -> newCity
//            findMember.getHomeAddress().setCity("newCity");
//            System.out.println("================ START ================");
//
//
//            Address a = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", a.getStreet(), a.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");

//            findMember.getAddresseHistory().remove(new AddressEntity("old1", "street", "zipcode"));
//            findMember.getAddresseHistory().add(new AddressEntity("newCity1", "street1", "10000"));

            /* JPQL */
//            List<Member> result = em.createQuery(
//                    "select m From Member m where m.username like '%kim%'",
//                    Member.class
//            ).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

            /* Criteria */
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq = query.select(m);
//
//            String username = "dsafas";
//            if (username != null) {
//                cq = cq.where(cb.equal(m.get("username"), "kim"));
//            }
//
//            List<Member> resultList = em.createQuery(cq)
//                    .getResultList();

            /* native query */
//            List resultList = em.createNativeQuery("select Member_ID, city, street, zipcode, USERNAME from MEMBER")
//                    .getResultList();



            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

//    private static void logic(Member m1, Member m2) {
////        System.out.println("m1.getClass() == m2.getClass() = " + (m1.getClass() == m2.getClass()));
//        System.out.println("m1 = " + (m1 instanceof Member));
//        System.out.println("m2 = " + (m2 instanceof Member));
//    }
//
//    private static void printMember(Member member) {
//        System.out.println("member.getUsername() = " + member.getUsername());
//    }
//
//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username = " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team.getName() = " + team.getName());
//    }
//
//    private static Member saveMember(EntityManager em) {
//        Member member = new Member();
//        member.setUsername("member1");
//
//        em.persist(member);
//        return member;
//    }
}
