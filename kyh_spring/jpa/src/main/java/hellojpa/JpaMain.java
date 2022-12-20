package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String args[]){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            List<Member> result = em.createQuery(
                    "select m From Member m where m.name like '%kim%'"
                    , Member.class
            ).getResultList();
            for (Member member : result) {
                System.out.println("member = " + member);
            }
            tx.commit();//commit시 아무일도 없음
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

}
