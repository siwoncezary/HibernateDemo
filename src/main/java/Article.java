import com.sun.javafx.beans.IDProperty;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

  @ManyToMany(cascade = { CascadeType.ALL} )
  @JoinTable(
          name = "article_tag",
          joinColumns = {@JoinColumn(name="article_id")},
          inverseJoinColumns = {@JoinColumn(name ="tag_id")}
          )
  private Set<Tag> tags = new HashSet<Tag>();

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

  public Set<Tag> getTags() {
    return tags;
  }

  public void setTags(Set<Tag> tags) {
    this.tags = tags;
  }
}
