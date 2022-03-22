package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //코드 추가
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member1.setUsername("member2");
            em.persist(member2);

            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            Team team2 = new Team();
            team.setName("team2");
            em.persist(team2);

            member1.addTeam(team);
            member2.addTeam(team2);

            em.flush();
            em.clear();

            List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();




            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        em.close();
        emf.close();

    }
}
