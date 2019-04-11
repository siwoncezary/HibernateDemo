import javax.persistence.*;
import java.lang.annotation.Target;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="author")
public class Author {
  @Id
  @GeneratedValue
  @Column(name ="id", unique = true, nullable = false)
  private long id;

  @Column(name="first_name")
  private String firstName;

  @Column(name="last_name")
  private String lastName;

  @OneToMany(mappedBy = "author")
  private Set<Article> articles = new HashSet<Article>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Set<Article> getArticles() {
    return articles;
  }

  public void setArticles(Set<Article> articles) {
    this.articles = articles;
  }

  @Override
  public String toString() {
    return "Author{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }
}
