package io.r3k.gamify9dotcom.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PassedChallege {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @ManyToOne
    private Player player;
    
    private String challenge;
    
    private LocalDateTime passedAt;

    public PassedChallege(Player player, String challenge) {
        this.player = player;
        this.challenge = challenge;
        this.passedAt = LocalDateTime.now();
    }
}
