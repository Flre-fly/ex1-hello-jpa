package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;

public class JpaMain {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        //코드 추가
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try{
            Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getName());
            findMember.setName("바뀐이름");
            System.out.println(findMember.getName());

            //이때 em.persist를 하지 않아도 된다
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        em.close();
        emf.close();

    }
}
