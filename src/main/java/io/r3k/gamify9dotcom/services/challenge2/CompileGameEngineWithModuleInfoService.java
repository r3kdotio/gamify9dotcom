package io.r3k.gamify9dotcom.services.challenge2;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import io.r3k.gamify9dotcom.services.challenge.AbstractChallenge;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/challenge2", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CompileGameEngineWithModuleInfoService extends AbstractChallenge {

  public CompileGameEngineWithModuleInfoService() {
    super("challenge2.compilegameenginewithmoduleinfoservice");
  }

  @PostMapping(path = "/compilegameenginewithmoduleinfo/withemptymoduleinfo")
  public ResponseEntity<ChallengeReponse> readInputWithEmptyModuleInfo(@RequestBody @NotNull String givenString) {
    if (givenString.contains("package com.threed.jpct is not visible")) {
      return new ResponseEntity<>(new ChallengeReponse(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(new ChallengeReponse("Output does not contain expected errors"), HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping(path = "/compilegameenginewithmoduleinfo/readinputwithmoduleinfodesktop")
  public ResponseEntity<ChallengeReponse> readInputWithModuleInfoDesktop(@RequestBody @NotNull String givenString) {
    if (givenString.contains("error: package com.threed.jpct.util is not visible")) {
      return success();
    }
    return failure("Output does not contain expected errors");
  }
  @PostMapping(path = "/compilegameenginewithmoduleinfo/readinputwithmoduleinfodesktopandjpct")
  public ResponseEntity<ChallengeReponse> readInputWithModuleInfoDesktopAndJPCT(@RequestBody @NotNull String givenString) {
    if (givenString.contains("errors")) {
      return new ResponseEntity<>(new ChallengeReponse("Compile still contains errors"), HttpStatus.BAD_REQUEST);
    } else if (givenString.contains("warning: [module] module name component gamify9 should avoid terminal digits")) {
      return new ResponseEntity<>(new ChallengeReponse(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(new ChallengeReponse("Output does not contain expected errors"), HttpStatus.BAD_REQUEST);
    }
  }
}
