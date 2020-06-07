package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;

@Entity
//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'comments'. Hence the table named 'comments' will be created in the database with all the columns mapped to all the attributes in 'Comment' class
@Table(name="comments")
public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    // Text is a Postgres column type that allows you to save
    // text based data that will be longer than 256 characters
    @Column(name = "TEXT")
    private String text;

    //LocalDate
    @Column(name = "created_date")
    private Date createdDate;

    //'comments' table is mapped to 'images' table- Many:One mapping
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Join primary key in 'images' table- 'image_id'
    @JoinColumn(name = "image_id")
    private Image image;

    // 'comments' table is mapped to 'users' table- Many:One mapping
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Join the primary key in 'users'- 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
