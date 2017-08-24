package io.r3k.gamify9dotcom.repositories;

import ch.qos.logback.core.net.server.Client;
import io.r3k.gamify9dotcom.domain.Player;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlayerRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerRepository playerRepository;

    @Test
    public void testFindByName() {
        //given
        final Player given = new Player("Player1");
        entityManager.persist(given);
        //when
        Optional<Player> player = playerRepository.findByUserName("Player1");
        //then
        assertEquals("Player1", player.get().getUserName());
    }
}