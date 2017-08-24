package io.r3k.gamify9dotcom.services.challenge1;

import io.r3k.gamify9dotcom.domain.ChallengeReponse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class JavaVersionServiceTest {

    @Test
    public void shouldRespondWithSuccessForValidJava9JarJPCT() {
        //given
        String givenString = "No module descriptor found. Derived automatic module.\n" +
"\n" +
"jpct@1 automatic\n" +
"requires java.base mandated\n" +
"contains com.threed.jpct\n" +
"contains com.threed.jpct.procs\n" +
"contains com.threed.jpct.threading\n" +
"contains com.threed.jpct.util";
        //when
        JavaVersionService underTest = new JavaVersionService();
        ResponseEntity<ChallengeReponse> response = underTest.readJavaVersion(givenString);
        //then
        
        assertNull(response.getBody().getMessage());
        assertEquals(HttpStatus.ACCEPTED,response.getStatusCode());
    }

    @Test
    public void shouldNotRespondWithSuccessForInValid() {
        //given
        String givenString = "This is some JUNK!!!";
        //when
        JavaVersionService underTest = new JavaVersionService();
        ResponseEntity<ChallengeReponse> response = underTest.readJavaVersion(givenString);
        //then
        assertEquals("Unable to read output for jar -d --file=3rdparty/jpct-1.jar . Are you running Java 9 ?", response.getBody().getMessage());
        assertEquals(HttpStatus.BAD_REQUEST,response.getStatusCode());
    }
}
