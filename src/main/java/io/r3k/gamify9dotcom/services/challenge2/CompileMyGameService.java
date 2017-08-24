package io.r3k.gamify9dotcom.services.challenge2;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/challenge2", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CompileMyGameService {

  @PostMapping(path = "/compilemygame/compilewithoutmoduledir")
  public ResponseEntity<ChallengeReponse> compileWithoutModuleDir(String givenString) {
    if (givenString.contains("error: module not found: com.gamify9.gameengine")) {
      return new ResponseEntity<>(new ChallengeReponse(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(new ChallengeReponse("Compile does not contain expected error"), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "/compilemygame/compilewithmoduledir")
  public ResponseEntity<ChallengeReponse> compileWithModuleDir(String givenString) {
    if (givenString.contains("mods/com.gamify9.mygame")) {
      return new ResponseEntity<>(new ChallengeReponse(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(new ChallengeReponse("Compile does not contain expected output of compile to mods/com.gamify9.mygame"), HttpStatus.BAD_REQUEST);
    }
  }

}
