package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    @Id
    private Integer id;

    private String username;

    private Date date;

    //for mapping with User and Images
    /*@ManyToOne
    private User user;

    @OneToMany(mappedBy = "image", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private Image image;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*public User getUser() {
        //return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }*/
}
