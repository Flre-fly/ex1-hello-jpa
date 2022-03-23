package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

            member1.getFavoriteFoods().add("족발");
            member1.getFavoriteFoods().add("보쌈");
            member1.getFavoriteFoods().add("피자");

            member1.getAddressHistory().add(new Address("old1", "a", "100"));
            member1.getAddressHistory().add(new Address("old2", "a", "100"));

            em.persist(member1);

            em.flush();
            em.clear();
            System.out.println("=========start==========");
            Member findMember = em.find(Member.class, member1.getId());
            Set<String> favoriteFoods  = findMember.getFavoriteFoods();
            for(String favoriteFood : favoriteFoods){
                System.out.println(favoriteFood);
            }




            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();
        }
        em.close();
        emf.close();

    }
}
