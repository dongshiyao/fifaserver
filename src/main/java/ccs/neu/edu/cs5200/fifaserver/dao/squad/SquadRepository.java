package ccs.neu.edu.cs5200.fifaserver.dao.squad;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Squad;

public interface SquadRepository extends CrudRepository<Squad, Long> {
  @Modifying
  @Query("update Squad s set s.squadName = ?1 where s.squadId = ?2")
  int setFixedSquadNameFor(Long squadId, String squadName);
}
