package jpabook.jpashop;

import jpabook.jpashop.domain.Book;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        /* EntityManagerFactory는 시작 시 하나만 생성해야 한다. */
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        /* JPA를 시작하기 위해 transaction 시작 */
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

//            Order order = new Order();
//            order.addOrderItem(new OrderItem());
//            em.persist(order);
//
//            OrderItem orderItem = new OrderItem();
//            orderItem.setOrder(order);
//
//            em.persist(orderItem);

            Book book = new Book();
            book.setName("JPA");
            book.setAuthor("김영한");

            em.persist(book);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
