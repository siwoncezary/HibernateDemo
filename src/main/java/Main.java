import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    EntityManager em = emf.createEntityManager();
    //creating author
    Author a = new Author();
    a.setFirstName("JAROSŁAW");
    a.setLastName("BACZYNSKI");
    Article art = new Article();
    //adding author to article
    art.setAuthor(a);
    art.setTitle("1000+");
    art.setContent("Dla Każdego");
    //creating two tga
    Tag t1 = new Tag();
    t1.setTitle("Java");
    t1.setArticles(new HashSet<Article>(Arrays.asList(art)));
    Tag t2 = new Tag();
    t2.setTitle("Polityka");
    t2.setArticles(new HashSet<Article>(Arrays.asList(art)));
    //adding tag to article
    art.setTags(new HashSet<Tag>(Arrays.asList(t1, t2)));
    em.getTransaction().begin();
    em.persist(a);
    em.persist(art);
    em.getTransaction().commit();
    em.close();
    emf.close();
  }
}
