package jpql;


import javax.persistence.*;
import java.util.List;


public class JpaMain {
    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team teamA = new Team();
            teamA.setName("A");
            em.persist(teamA);
            Team teamB = new Team();
            teamB.setName("B");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(10);
            member1.changeTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(10);
            member2.changeTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(10);
            member3.changeTeam(teamB);
            em.persist(member3);
            
            // FLUSH 자동 호출
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();
            em.clear();
            Member findMember = em.find(Member.class, member1.getId());

            System.out.println("resultCount = " + resultCount);

            System.out.println("member1 = " + member1.getAge());
            System.out.println("member1 = " + member2.getAge());
            System.out.println("member1 = " + member3.getAge());

            tx.commit();//commit시 아무일도 없음
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }

}

