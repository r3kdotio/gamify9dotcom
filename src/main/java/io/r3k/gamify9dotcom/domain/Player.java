package io.r3k.gamify9dotcom.domain;

import java.util.List;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    @OneToMany(mappedBy = "player")
    private List<PassedChallege> passedChalleges;

    public Player(String userName) {
        this.userName = userName;
    }

}
