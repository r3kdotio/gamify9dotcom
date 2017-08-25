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
public class CompileGameEngineWithoutModuleInfoService extends AbstractChallenge {

  public CompileGameEngineWithoutModuleInfoService() {
    super("challenge2.compilegameenginewithoutmoduleinfoservice");
  }

  @PostMapping(path = "/compilegameenginewithoutmoduleinfo")
  public ResponseEntity<ChallengeReponse> readInput(@RequestBody @NotNull String givenString) {
    //TODO Not sure what is best to check for here. Check on Windows and MacOS
    if (givenString.contains("loading /modules/java.desktop/module-info.class")){
      return success();
    } else {
      return failure("Output does not match the verbose compilation of the game engine");
    }
  }
  
}
