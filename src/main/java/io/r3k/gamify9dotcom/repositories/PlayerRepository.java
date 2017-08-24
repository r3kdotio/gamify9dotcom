
package io.r3k.gamify9dotcom.repositories;

import io.r3k.gamify9dotcom.domain.Player;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {

    Optional<Player> findByUserName(String userName);
    
}
