package ccs.neu.edu.cs5200.fifaserver.dao.player;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
