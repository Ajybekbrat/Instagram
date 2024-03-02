package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_infos")
@NoArgsConstructor
@Setter
@Getter
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_UserInfo")
    @SequenceGenerator(name = "generator_UserInfo", sequenceName = "User_Info", allocationSize = 1, initialValue = 1)
    private Long id;
    private String fullName;
    private String biography;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String image;
    @OneToOne(cascade = CascadeType.MERGE)
    private User user;

    @Override
    public String toString() {
        return "UserInfo{" +
                "fullName='" + fullName + '\'' +
                ", biography='" + biography + '\'' +
                ", gender=" + gender +
                ", image='" + image + '\'' +
                '}';
    }
}
