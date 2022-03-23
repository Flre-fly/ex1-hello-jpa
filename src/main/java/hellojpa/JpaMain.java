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
            Address address = new Address();
            address.setCity("city");
            address.setStreet("길1");
            address.setZipcode("zipcodeeee");

            Member member1 = new Member();
            member1.setUsername("member1");
            //member1.setHomeAddress(address);
            member1.setHomeAddress(new Address(address.getZipcode(), address.getStreet(), address.getCity()));
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setHomeAddress(address);
            em.persist(member2);

            member1.getHomeAddress().setCity("변경된 city");

            Address address2 = new Address(address.getZipcode(), address.getStreet(), address.getCity());

            System.out.println(address2.equals(address));


            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        em.close();
        emf.close();

    }
}
