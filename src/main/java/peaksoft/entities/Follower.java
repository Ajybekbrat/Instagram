package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "followers")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Builder
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follow_gen")
    @SequenceGenerator(name = "follow_gen", sequenceName = "follow_gen", allocationSize = 1, initialValue = 1)
    private Long id;
    @ElementCollection
    private List<Long> subscribers;
    @ElementCollection
    private List<Long> subscriptions;
    @OneToOne
    private User user;

    @Override
    public String toString() {
        return "Follower{" +
                "subscribers=" + subscribers +
                ", subscriptions=" + subscriptions +
                '}';
    }
}
