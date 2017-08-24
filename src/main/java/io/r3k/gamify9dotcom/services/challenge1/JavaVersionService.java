package io.r3k.gamify9dotcom.services.challenge1;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import io.r3k.gamify9dotcom.services.challenge.AbstractChallenge;
import javax.validation.constraints.NotNull;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/challenge1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class JavaVersionService extends AbstractChallenge {

  public JavaVersionService() {
    super("challenge1.javaversionservice");
  }

  @PostMapping(path = "/readjavaversion")
  public ResponseEntity<ChallengeReponse> readJavaVersion(@RequestBody @NotNull String givenString) {
    if (givenString.contains("jpct@1 automatic")) {
      return success();
    }
    return failure("Unable to read output for jar -d --file=3rdparty/jpct-1.jar . Are you running Java 9 ?");
  }
}
