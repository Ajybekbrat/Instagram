package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "images")
@NoArgsConstructor
@Setter
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_gen")
    @SequenceGenerator(name = "image_gen", sequenceName = "image_seq", allocationSize = 1, initialValue = 1)
    private Long id;
    private String imageUsl;
@OneToMany(mappedBy = "image")
private List<User> users;
@ManyToOne(cascade = CascadeType.PERSIST)
private Post post;

    @Override
    public String toString() {
        return "Image{" +
                "imageUsl='" + imageUsl + '\'' +
                '}';
    }
}
