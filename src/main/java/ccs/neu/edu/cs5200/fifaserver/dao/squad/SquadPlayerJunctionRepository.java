package ccs.neu.edu.cs5200.fifaserver.dao.squad;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerKey;

public interface SquadPlayerJunctionRepository extends CrudRepository<SquadPlayerJunction, SquadPlayerKey> {
  List<SquadPlayerJunction> findBySquadId(Long squadId);

  List<SquadPlayerJunction> removeBySquadId(Long squadId);
}
