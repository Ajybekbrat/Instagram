package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likes")
@NoArgsConstructor
@Setter
@Getter
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_gen")
    @SequenceGenerator(name = "like_gen", sequenceName = "like_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private boolean isLike;
@ManyToOne
private Post post;
@ManyToOne
private Comment comment;
@OneToOne
private User user;


    @Override
    public String toString() {
        return "Like{" +
                "isLike=" + isLike +
                '}';
    }
}
