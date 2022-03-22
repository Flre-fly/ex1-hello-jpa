package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transaction;
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
            Movie movie = new Movie();
            movie.setActor("배우1");
            movie.setDirector("감독1");
            movie.setName("바람과함께사라지다");
            movie.setPrice(1000);
            em.persist(movie);

            //영속성 컨텍스트에 있는걸 다 날려서 디비로의 조회 쿼리를 날리도록 한다
            em.flush();
            em.clear();


            //movie를 가져오려면 item과 join해서 가져와야겠지?
            Movie findMovie = em.find(Movie.class, 1L);
            System.out.println(findMovie.getName() + "dddddddddddddddddddddddd");

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }
        em.close();
        emf.close();

    }
}
