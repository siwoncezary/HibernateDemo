import javax.persistence.*;

@Entity
@Table(name ="tag")
public class Tag {
  @Id
  @GeneratedValue
  @Column (name="id", unique = true, nullable = false)
  private long id;
  @Column(name="title")
  private String title;

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
}
