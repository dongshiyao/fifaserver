package ccs.neu.edu.cs5200.fifaserver.dao.user;

import org.springframework.data.repository.CrudRepository;

import ccs.neu.edu.cs5200.fifaserver.domain.user.UserSquadJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.user.UserSquadKey;

public interface UserSquadJunctionRepository extends CrudRepository<UserSquadJunction, UserSquadKey> {

}
