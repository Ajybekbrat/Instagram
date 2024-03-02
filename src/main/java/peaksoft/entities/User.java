package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 0, initialValue = 1)
    private Long id;
    @Column(unique = true)
    private String user_name;
    private String password;
    @Column(unique = true)
    private String email;
    @Column(unique = true, length = 13)
    private String phone_number;
    @OneToOne
    private Like like;
    @ManyToMany(cascade = {CascadeType.PERSIST, REMOVE, REFRESH}, fetch = FetchType.EAGER)
    private List<Comment> comments;
    @OneToMany(mappedBy = "user", cascade = {PERSIST, REMOVE, REFRESH}, fetch = FetchType.EAGER)
    private List<Post> posts;

    @OneToOne(mappedBy = "user", cascade = {REMOVE, PERSIST})
    private Follower follower;
    @OneToOne(mappedBy = "user", fetch = FetchType.EAGER, cascade = {PERSIST, MERGE})
    private UserInfo userInfo;
    @ManyToOne(cascade = PERSIST)
    private Image image;


    public void addComment(Comment comment){
        if (this.comments == null) this.comments = new ArrayList<>();
        this.comments.add(comment);
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phone_number + '\'' +
                '}';
    }
}
