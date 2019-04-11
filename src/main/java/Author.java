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

  @Column(name="name")
  private String name;

  @OneToMany(mappedBy = "author")
  private Set<Article> articles = new HashSet<Article>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
