import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class QueryDemo {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    EntityManager em = emf.createEntityManager();
    List<Tag> list = em.createQuery("From Tag").getResultList();
    list.stream().forEach(System.out::println);
    System.out.println("List of articles tagged by " + list.get(0));
    for (Article a: list.get(0).getArticles()){
      System.out.println(a);
    }


    List<Article> arts = em.createQuery("From Article").getResultList();
    System.out.println("List of tags for " + arts.get(0));
    for(Tag t: arts.get(0).getTags()){
      System.out.println(t);
    }

  }
}
