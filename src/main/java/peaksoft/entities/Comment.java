package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REFRESH;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Setter @Getter
@AllArgsConstructor
@Builder

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_gen")
    @SequenceGenerator(name = "comment_gen", sequenceName = "comment_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String comment;
    private LocalDate creatAt = LocalDate.now();

    @ManyToOne(cascade = PERSIST,fetch = FetchType.EAGER)
    private Post posts;
    @ManyToMany(mappedBy = "comments",cascade = {PERSIST,REFRESH},fetch = FetchType.EAGER)
    private List<User> users;


    @OneToMany(mappedBy = "comment")
    private List<Like> like;
    @Override
    public String toString() {
        return "Comment{" +
                "comment='" + comment + '\'' +
                ", creatAt=" + creatAt +
                '}';
    }
}
