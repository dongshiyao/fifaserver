package ccs.neu.edu.cs5200.fifaserver.dao.player;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;
import ccs.neu.edu.cs5200.fifaserver.domain.player.SearchCriteria;

public interface PlayerDao {
  List<Player> searchByCriteria(SearchCriteria searchCriteria);

  List<String> searchNationByFirstLetterInRange(Character start, Character end);

  List<String> searchLeagueByFirstLetterInRange(Character start, Character end);

  List<String> searchClubByLeague(String leagueName);
}
