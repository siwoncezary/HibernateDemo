import com.sun.javafx.beans.IDProperty;
import javax.persistence.*;

@Entity
@Table(name="article")
public class Article {
  @Id
  @GeneratedValue
  @Column(name="id", unique = true, nullable = false)
  private long id;

  @Column(name="title")
  private String title;

  @Column(name="content")
  private String content;

  @ManyToOne
  @JoinColumn(name="author_id", nullable=false)
  private Author author;

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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
