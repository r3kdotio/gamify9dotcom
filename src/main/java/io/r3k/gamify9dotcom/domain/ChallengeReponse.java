package io.r3k.gamify9dotcom.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChallengeReponse {

    private String message;

    public ChallengeReponse( String message) {
        this.message = message;
    }

}
