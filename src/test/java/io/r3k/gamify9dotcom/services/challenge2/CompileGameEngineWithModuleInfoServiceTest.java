package io.r3k.gamify9dotcom.services.challenge2;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CompileGameEngineWithModuleInfoServiceTest {

  @Test
  public void shouldRespondWithSuccessForCompilationErrorEmptyModuleInfo() {
    //given
    String givenString = "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:3: error: package java.awt is not visible\n"
            + "import java.awt.Color;\n"
            + "           ^\n"
            + "  (package java.awt is declared in module java.desktop, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:4: error: package java.awt is not visible\n"
            + "import java.awt.Graphics;\n"
            + "           ^\n"
            + "  (package java.awt is declared in module java.desktop, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:5: error: package java.awt.event is not visible\n"
            + "import java.awt.event.KeyEvent;\n"
            + "               ^\n"
            + "  (package java.awt.event is declared in module java.desktop, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:6: error: package javax.swing is not visible\n"
            + "import javax.swing.JFrame;\n"
            + "            ^\n"
            + "  (package javax.swing is declared in module java.desktop, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:8: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Camera;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:9: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Config;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:10: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.FrameBuffer;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:11: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.IRenderer;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:12: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Object3D;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:13: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Primitives;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:14: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.SimpleVector;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:15: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.World;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:16: error: package com.threed.jpct.util is not visible\n"
            + "import com.threed.jpct.util.KeyMapper;\n"
            + "                      ^\n"
            + "  (package com.threed.jpct.util is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:17: error: package com.threed.jpct.util is not visible\n"
            + "import com.threed.jpct.util.KeyState;\n"
            + "                      ^\n"
            + "  (package com.threed.jpct.util is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:18: error: package com.threed.jpct.util is not visible\n"
            + "import com.threed.jpct.util.Light;\n"
            + "                      ^\n"
            + "  (package com.threed.jpct.util is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/module-info.java:1: warning: [module] module name component gamify9 should avoid terminal digits\n"
            + "module com.gamify9.gameengine {\n"
            + "          ^\n"
            + "15 errors\n"
            + "1 warning";
    //when
    CompileGameEngineWithModuleInfoService underTest = new CompileGameEngineWithModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInputWithEmptyModuleInfo(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

  }

  @Test
  public void shouldRespondWithErrorIfInputIsEmptyEmptyModuleInfo() {
    //given
    String givenString = "";
    //when
    CompileGameEngineWithModuleInfoService underTest = new CompileGameEngineWithModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInputWithEmptyModuleInfo(givenString);
    //then
    assertEquals("Output does not contain expected errors", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldRespondWithSuccessForCompilationErrorMissingJPCTAndLWJGL() {
    //given
    String givenString = "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:8: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Camera;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:9: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Config;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:10: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.FrameBuffer;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:11: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.IRenderer;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:12: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Object3D;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:13: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.Primitives;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:14: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.SimpleVector;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:15: error: package com.threed.jpct is not visible\n"
            + "import com.threed.jpct.World;\n"
            + "                 ^\n"
            + "  (package com.threed.jpct is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:16: error: package com.threed.jpct.util is not visible\n"
            + "import com.threed.jpct.util.KeyMapper;\n"
            + "                      ^\n"
            + "  (package com.threed.jpct.util is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:17: error: package com.threed.jpct.util is not visible\n"
            + "import com.threed.jpct.util.KeyState;\n"
            + "                      ^\n"
            + "  (package com.threed.jpct.util is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java:18: error: package com.threed.jpct.util is not visible\n"
            + "import com.threed.jpct.util.Light;\n"
            + "                      ^\n"
            + "  (package com.threed.jpct.util is declared in module jpct, but module com.gamify9.gameengine does not read it)\n"
            + "com.gamify9.gameengine/module-info.java:1: warning: [module] module name component gamify9 should avoid terminal digits\n"
            + "module com.gamify9.gameengine {\n"
            + "          ^\n"
            + "11 errors\n"
            + "1 warning";
    //when
    CompileGameEngineWithModuleInfoService underTest = new CompileGameEngineWithModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInputWithModuleInfoDesktop(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

  }

  @Test
  public void shouldRespondWithErrorIfInputIsEmptyEmptyModuleInfoDesktop() {
    //given
    String givenString = "";
    //when
    CompileGameEngineWithModuleInfoService underTest = new CompileGameEngineWithModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInputWithModuleInfoDesktop(givenString);
    //then
    assertEquals("Output does not contain expected errors", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldReturnSuccessOnSuccessfulCompileWithNotErrors() {

    //given
    String givenString = "com.gamify9.gameengine/module-info.java:1: warning: [module] module name component gamify9 should avoid terminal digits\n"
            + "module com.gamify9.gameengine {\n"
            + "          ^\n"
            + "1 warning";

    //when
    CompileGameEngineWithModuleInfoService underTest = new CompileGameEngineWithModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInputWithModuleInfoDesktop(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

  }
  @Test
  public void shouldReturnFailureOnSuccessfulCompileWithNotErrors() {

    //given
    String givenString = "com.gamify9.gameengine/module-info.java:1: warning: [module] module name component gamify9 should avoid terminal digits\n"
            + "module com.gamify9.gameengine {\n"
            + "          ^\n"
            + "11 errors"
            + "1 warning";

    //when
    CompileGameEngineWithModuleInfoService underTest = new CompileGameEngineWithModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInputWithModuleInfoDesktop(givenString);
    //then
    assertEquals("Compile still contains errors",response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

  }
}
