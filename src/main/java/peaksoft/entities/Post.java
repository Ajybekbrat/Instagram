package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JFormattedTextField.PERSIST;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Setter
@Getter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_gen")
    @SequenceGenerator(name = "post_gen", sequenceName = "post_seq", allocationSize = 0, initialValue = 1)
    private Long id;
    private String title;
    private String description;
    private LocalDate creatAt = LocalDate.now();
    @ManyToOne(cascade = CascadeType.PERSIST)
private User user;
    @OneToMany (mappedBy = "posts",cascade = {CascadeType.PERSIST} ,fetch = FetchType.EAGER)
    private List<Comment> comment;
    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)

    private List<Image>images;
    @OneToMany(mappedBy = "post")
    private List<Like>likes;
    @Transient
    private String imageUrl;
    public void addImage(Image image) {
        if (images == null) images = new ArrayList<>();
        images.add(image);
    }
    public void addComment(Comment comment) {
        if (this.comment == null) this.comment = new ArrayList<>();
        this.comment.add(comment);
    }
    @Override
    public String toString() {
        return "Post{" +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creatAt=" + creatAt +
                '}';
    }
}
