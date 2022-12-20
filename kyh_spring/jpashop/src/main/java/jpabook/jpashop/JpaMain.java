package jpabook.jpashop;



import jpabook.jpashop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("shop");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Book book = new Book();
            book.setName("JPA");
            book.setAuthur("김영한");
            em.persist(book);
            tx.commit();//commit시 아무일도 없음
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }
}
