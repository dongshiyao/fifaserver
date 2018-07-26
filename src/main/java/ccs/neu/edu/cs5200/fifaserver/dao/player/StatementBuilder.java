package ccs.neu.edu.cs5200.fifaserver.dao.player;

import ccs.neu.edu.cs5200.fifaserver.domain.player.SearchCriteria;

public interface StatementBuilder {
  String buildStatementByPlayerName(String playerName);

  String buildStatementByCriteria(SearchCriteria searchCriteria);

  String buildStatementNationByFirstLetterInRange(Character start, Character end);

  String buildStatementLeagueByFirstLetterInRange(Character start, Character end);

  String buildStatementClubByLeague(String leagueName);
}
