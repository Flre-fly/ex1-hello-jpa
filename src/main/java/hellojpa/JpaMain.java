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
            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();
            //영속성 컨텍스트가 비워짐

            Parent p1 = em.find(Parent.class, parent.getId());


            System.out.println("---------------");
            p1.getChildList().remove(0);
            System.out.println("---------------");


            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }
        em.close();
        emf.close();

    }
}
