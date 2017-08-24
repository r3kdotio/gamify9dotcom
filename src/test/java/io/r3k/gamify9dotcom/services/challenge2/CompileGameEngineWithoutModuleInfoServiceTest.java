package io.r3k.gamify9dotcom.services.challenge2;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CompileGameEngineWithoutModuleInfoServiceTest {

  @Test
  public void shouldRespondWithSuccessForCompilationVerbose() {
    //given
    String givenString = "[parsing started SimpleFileObject[/home/richard/src/r3kdotio/j9modules/com.gamify9.gameengine/com/gamify9/gameengine/score/GameScore.java]]\n"
            + "[parsing completed 18ms]\n"
            + "[parsing started SimpleFileObject[/home/richard/src/r3kdotio/j9modules/com.gamify9.gameengine/com/gamify9/gameengine/GameEngine.java]]\n"
            + "[parsing completed 7ms]\n"
            + "[loading mods/com.gamify9.gameengine/module-info.class]\n"
            + "[loading /modules/java.desktop/module-info.class]\n"
            + "[loading /modules/java.datatransfer/module-info.class]\n"
            + "[loading /modules/java.xml/module-info.class]\n"
            + "[loading /modules/java.prefs/module-info.class]\n"
            + "[loading /modules/java.base/module-info.class]\n"
            + "[loading /modules/java.base/java/lang/Object.class]\n"
            + "[loading /modules/java.desktop/java/awt/Color.class]\n"
            + "[loading /modules/java.desktop/java/awt/Graphics.class]\n"
            + "[loading /modules/java.desktop/java/awt/event/KeyEvent.class]\n"
            + "[loading /modules/java.desktop/javax/swing/JFrame.class]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/Camera.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/Config.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/FrameBuffer.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/IRenderer.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/Object3D.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/Primitives.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/SimpleVector.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/World.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/util/KeyMapper.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/util/KeyState.class)]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/util/Light.class)]\n"
            + "[loading /modules/java.base/java/lang/Exception.class]\n"
            + "[loading /modules/java.base/java/lang/Deprecated.class]\n"
            + "[loading /modules/java.desktop/java/beans/ConstructorProperties.class]\n"
            + "[loading /modules/java.desktop/java/beans/JavaBean.class]\n"
            + "[loading /modules/java.desktop/javax/swing/SwingContainer.class]\n"
            + "[loading /modules/java.desktop/java/beans/BeanProperty.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/Retention.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/RetentionPolicy.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/Target.class]\n"
            + "[loading /modules/java.base/java/lang/annotation/ElementType.class]\n"
            + "[checking com.gamify9.gameengine.score.GameScore]\n"
            + "[loading /modules/java.base/java/io/Serializable.class]\n"
            + "[loading /modules/java.base/java/lang/AutoCloseable.class]\n"
            + "[loading /modules/java.base/java/lang/System.class]\n"
            + "[loading /modules/java.base/java/io/PrintStream.class]\n"
            + "[loading /modules/java.base/java/lang/String.class]\n"
            + "[loading /modules/java.base/java/lang/Appendable.class]\n"
            + "[loading /modules/java.base/java/io/Closeable.class]\n"
            + "[loading /modules/java.base/java/io/FilterOutputStream.class]\n"
            + "[loading /modules/java.base/java/io/OutputStream.class]\n"
            + "[loading /modules/java.base/java/io/Flushable.class]\n"
            + "[loading /modules/java.base/java/lang/Integer.class]\n"
            + "[loading /modules/java.base/java/lang/Number.class]\n"
            + "[loading /modules/java.base/java/util/Locale.class]\n"
            + "[loading /modules/java.base/java/lang/Byte.class]\n"
            + "[loading /modules/java.base/java/lang/Character.class]\n"
            + "[loading /modules/java.base/java/lang/Short.class]\n"
            + "[loading /modules/java.base/java/lang/Long.class]\n"
            + "[loading /modules/java.base/java/lang/Float.class]\n"
            + "[loading /modules/java.base/java/lang/Double.class]\n"
            + "[loading /modules/java.base/java/lang/Boolean.class]\n"
            + "[loading /modules/java.base/java/lang/Void.class]\n"
            + "[loading /modules/java.base/java/lang/Comparable.class]\n"
            + "[wrote DirectoryFileObject[mods/com.gamify9.gameengine:com/gamify9/gameengine/score/GameScore.class]]\n"
            + "[checking com.gamify9.gameengine.GameEngine]\n"
            + "[loading /modules/java.base/java/lang/Runtime.class]\n"
            + "[loading /modules/java.desktop/java/awt/Frame.class]\n"
            + "[loading /modules/java.desktop/java/awt/Window.class]\n"
            + "[loading /modules/java.desktop/java/awt/Container.class]\n"
            + "[loading /modules/java.desktop/java/awt/Component.class]\n"
            + "[loading /modules/java.desktop/java/awt/image/ImageObserver.class]\n"
            + "[loading /modules/java.desktop/java/awt/MenuContainer.class]\n"
            + "[loading /modules/java.desktop/javax/accessibility/Accessible.class]\n"
            + "[loading /modules/java.desktop/javax/swing/WindowConstants.class]\n"
            + "[loading /modules/java.desktop/javax/swing/RootPaneContainer.class]\n"
            + "[loading /modules/java.desktop/javax/swing/TransferHandler.class]\n"
            + "[loading /modules/java.desktop/javax/swing/TransferHandler$HasGetTransferHandler.class]\n"
            + "[loading /modules/java.base/java/lang/Math.class]\n"
            + "[loading /home/richard/src/r3kdotio/j9modules/3rdparty/jpct-1.jar(/com/threed/jpct/BufferedMatrix.class)]\n"
            + "[loading /modules/java.desktop/java/awt/event/KeyListener.class]\n"
            + "[loading /modules/java.base/java/util/EventListener.class]\n"
            + "[loading /modules/java.base/java/lang/Throwable.class]\n"
            + "[loading /modules/java.base/java/lang/Error.class]\n"
            + "[loading /modules/java.desktop/java/awt/HeadlessException.class]\n"
            + "[loading /modules/java.base/java/lang/UnsupportedOperationException.class]\n"
            + "[loading /modules/java.base/java/lang/RuntimeException.class]\n"
            + "[wrote DirectoryFileObject[mods/com.gamify9.gameengine:com/gamify9/gameengine/GameEngine.class]]\n"
            + "[total 460ms]";
    //when
    CompileGameEngineWithoutModuleInfoService underTest = new CompileGameEngineWithoutModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInput(givenString);
    //then
    assertNull(response.getBody().getMessage());
    assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());

  }
    @Test
  public void shouldRespondWithErrorIfInputIsEmpty() {
    //given
    String givenString = "";
    //when
    CompileGameEngineWithoutModuleInfoService underTest = new CompileGameEngineWithoutModuleInfoService();
    ResponseEntity<ChallengeReponse> response = underTest.readInput(givenString);
    //then
    assertEquals("Output does not match the verbose compilation of the game engine", response.getBody().getMessage());
    assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
  }
  
  
}
