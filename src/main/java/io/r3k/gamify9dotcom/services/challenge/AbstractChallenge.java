package io.r3k.gamify9dotcom.services.challenge;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractChallenge {

  protected final String name;

  public AbstractChallenge(String name) {
    this.name = name;
  }

  public ResponseEntity success() {
    return new ResponseEntity<>(new ChallengeReponse(), HttpStatus.ACCEPTED);
  }

  public ResponseEntity failure(String message) {
    return new ResponseEntity<>(new ChallengeReponse(message), HttpStatus.BAD_REQUEST);
  }

}
