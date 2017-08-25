package io.r3k.gamify9dotcom.services.challenge2;

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
@RequestMapping(path = "/api/challenge2", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CompileMyGameService extends AbstractChallenge {

  public CompileMyGameService() {
    super("challenge2.compilemygameservice");
  }

  @PostMapping(path = "/compilemygame/compilewithoutmoduledir")
  public ResponseEntity<ChallengeReponse> compileWithoutModuleDir(@RequestBody @NotNull String givenString) {
    if (givenString.contains("error: module not found: com.gamify9.gameengine")) {
      return success();
    } else {
      return failure("Compile does not contain expected error");
    }
  }

  @PostMapping(path = "/compilemygame/compilewithmoduledir")
  public ResponseEntity<ChallengeReponse> compileWithModuleDir(@RequestBody @NotNull String givenString) {
    if (givenString.contains("mods/com.gamify9.mygame")) {
      return success();
    } else {
      return failure("Compile does not contain expected output of compile to mods/com.gamify9.mygame");
    }
  }

}
