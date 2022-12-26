package entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode
@Entity
public class UserInformation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    int id;
    @Column(nullable = false, unique = true)
    String userName;
    @Column(nullable = false)
    String password;

    public UserInformation(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
