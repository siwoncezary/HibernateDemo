import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="tag")
public class Tag {

  @Id
  @GeneratedValue
  @Column (name="id", unique = true, nullable = false)
  private long id;

  @Column(name="title", unique = true)
  private String title;

  @ManyToMany(mappedBy = "tags")
  private Set<Article> articles = new HashSet<Article>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Set<Article> getArticles() {
    return articles;
  }

  public void setArticles(Set<Article> articles) {
    this.articles = articles;
  }

  @Override
  public String toString() {
    return "Tag{" +
            "title='" + title + '\'' +
            '}';
  }
}
