package ccs.neu.edu.cs5200.fifaserver.dao.squad;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.UserSquadJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.UserSquadKey;

public interface UserSquadJunctionRepository extends CrudRepository<UserSquadJunction, UserSquadKey> {
  List<UserSquadJunction> findByUserName(String userName);
}
