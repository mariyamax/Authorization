package authorization.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;


import javax.persistence.*;


@Entity
@Table(name = "users")
@Data
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long ID;
    @Column(name="user_name")
    private String username;
    @Column(name="password", length = 1000)
    private String password;

}

