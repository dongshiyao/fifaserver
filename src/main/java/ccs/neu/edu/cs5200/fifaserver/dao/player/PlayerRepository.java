package ccs.neu.edu.cs5200.fifaserver.dao.player;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {
  @Query("select c from Player c where c.league = ?1 group by c.club order by c.club")
  List<Player> findClubByLeague(String league);
}
