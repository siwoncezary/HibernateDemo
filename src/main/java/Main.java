import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
    EntityManager em = emf.createEntityManager();
    Author a = new Author();
    a.setName("TOLEK");
    Article art = new Article();
    art.setAuthor(a);
    art.setTitle("Hello");
    art.setContent("Hello World");
    em.getTransaction().begin();
    em.persist(a);
    em.persist(art);
    em.getTransaction().commit();
    em.close();
    emf.close();
  }
}
