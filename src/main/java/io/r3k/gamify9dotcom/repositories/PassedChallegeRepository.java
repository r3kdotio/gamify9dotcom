package io.r3k.gamify9dotcom.repositories;

import io.r3k.gamify9dotcom.domain.PassedChallege;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PassedChallegeRepository extends CrudRepository<PassedChallege, Long>{
    List<PassedChallege> findByPlayerUserName(String userName);
}
