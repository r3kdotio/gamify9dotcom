package io.r3k.gamify9dotcom.repositories;

import io.r3k.gamify9dotcom.domain.PassedChallege;
import io.r3k.gamify9dotcom.domain.Player;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PassedChallegeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PassedChallegeRepository passedChallegeRepository;

    @Test
    public void testFindByName() {
        //given
        Player givenPlayer = new Player("Player1");
        givenPlayer = entityManager.persist(givenPlayer);
        PassedChallege givenPassedChallege = new PassedChallege(givenPlayer, "challenge");
        entityManager.persist(givenPassedChallege);
        //when
        List<PassedChallege> passedChalleges = passedChallegeRepository.findByPlayerUserName("Player1");
        //then
        assertEquals(1, passedChalleges.size());
        final PassedChallege passedChallege = passedChalleges.get(0);
        assertEquals("challenge", passedChallege.getChallenge());
        assertNotNull(passedChallege.getPassedAt());
    }
}
