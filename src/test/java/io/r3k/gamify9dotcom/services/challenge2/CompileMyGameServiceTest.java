package io.r3k.gamify9dotcom.services.challenge2;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CompileMyGameServiceTest {

  @Test
  public void shouldReturnSuccessOnErrorCompileWithoutModuleDir() {
    //given
    String givenString = "[parsing started SimpleFileObject[/home/richard/src/r3kdotio/j9modules/com.gamify9.mygame/com/gamify9/mygame/MyGame.java]]\n"
            + "[parsing completed 19ms]\n"
            + "[loading mods/com.gamify9.mygame/module-info.class]\n"
            + "error: module not found: com.gamify9.gameengine\n"
            + "[loading /modules/java.base/module-info.class]\n"
            + "[total 132ms]\n"
            + "1 error";

    //when
    CompileMyGameService underTest = new CompileMyGameService();
    ResponseEntity<ChallengeReponse> response = underTest.compileWithoutModuleDir(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
  }

  @Test
  public void shouldReturnFailureOnEmptyCompileWithoutModuleDir() {
    //given
    String givenString = "";
    //when
    CompileMyGameService underTest = new CompileMyGameService();
    ResponseEntity<ChallengeReponse> response = underTest.compileWithoutModuleDir(givenString);
    //then
    assertEquals("Compile does not contain expected error", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }

  @Test
  public void shouldReturnSuccessOnErrorCompileWithModuleDir() {
    //given
    String givenString = "[parsing started SimpleFileObject[/home/richard/src/r3kdotio/j9modules/com.gamify9.mygame/com/gamify9/mygame/MyGame.java]]\n"
            + "[parsing completed 20ms]\n"
            + "[loading mods/com.gamify9.mygame/module-info.class]\n"
            + "[loading mods/com.gamify9.gameengine/module-info.class]\n"
            + "[loading /modules/jdk.unsupported/module-info.class]\n"
            + "[loading /modules/java.desktop/module-info.class]\n"
            + "[loading /modules/java.datatransfer/module-info.class]\n"
            + "[loading /modules/java.xml/module-info.class]\n"
            + "[loading /modules/java.prefs/module-info.class]\n"
            + "[loading /modules/java.base/module-info.class]\n"
            + "[loading /modules/java.base/java/lang/Object.class]\n"
            + "[loading /modules/java.base/java/lang/String.class]\n"
            + "[loading /modules/java.base/java/lang/Exception.class]\n"
            + "[loading /modules/java.base/java/lang/Deprecated.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/Retention.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/RetentionPolicy.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/Target.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/ElementType.class]\n"
            + "[checking com.gamify9.mygame.MyGame]\n"
            + "[loading /modules/java.base/java/io/Serializable.class]\n"
            + "[loading /modules/java.base/java/lang/AutoCloseable.class]\n"
            + "[loading /modules/java.base/java/lang/Throwable.class]\n"
            + "[loading mods/com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.class]\n"
            + "[loading /modules/java.base/java/lang/Error.class]\n"
            + "[loading /modules/java.base/java/lang/RuntimeException.class]\n"
            + "[wrote DirectoryFileObject[mods/com.gamify9.mygame:com/gamify9/mygame/MyGame.class]]\n"
            + "[total 284ms]";

    //when
    CompileMyGameService underTest = new CompileMyGameService();
    ResponseEntity<ChallengeReponse> response = underTest.compileWithModuleDir(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
  }

  @Test
  public void shouldReturnFailureOnEmptyCompileWithModuleDir() {
    //given
    String givenString = "";
    //when
    CompileMyGameService underTest = new CompileMyGameService();
    ResponseEntity<ChallengeReponse> response = underTest.compileWithModuleDir(givenString);
    //then
    assertEquals("Compile does not contain expected output of compile to mods/com.gamify9.mygame", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());

  }

}
