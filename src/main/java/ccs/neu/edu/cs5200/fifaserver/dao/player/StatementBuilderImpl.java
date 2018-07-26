package ccs.neu.edu.cs5200.fifaserver.dao.player;

import org.springframework.stereotype.Component;

import ccs.neu.edu.cs5200.fifaserver.domain.player.SearchCriteria;

@Component("statementBuilder")
public class StatementBuilderImpl implements StatementBuilder {
  private static final String START = "SELECT * FROM Player";
  private static final String SQL_SEARCH_NAME = "SELECT * FROM Player WHERE LOWER(PlayerName) LIKE '%%%s%%' ORDER BY Overall DESC;";
  private static final String SQL_SEARCH_NATION_START_WITH = "SELECT Nation FROM Player WHERE LOWER(Nation) REGEXP '^[%c-%c].*$' GROUP BY Nation ORDER BY Nation;";
  private static final String SQL_SEARCH_LEAGUE_START_WITH = "SELECT League FROM Player WHERE LOWER(League) REGEXP '^[%c-%c].*$' GROUP BY League ORDER BY League;";
  private static final String SQL_SEARCH_CLUB_BY_LEAGUE = "SELECT Club FROM Player WHERE League = '%s' GROUP BY Club ORDER BY Club;";
  private static final String CLAUSE_NATION = "Nation = '%s'";
  private static final String CLAUSE_LEAGUE = "League = '%s'";
  private static final String CLAUSE_CLUB = "Club = '%s'";
  private static final String CLAUSE_POSITION = "Position = '%s'";
  private static final String ORDER_BY = "ORDER BY %s DESC";
  private static final String AND = "AND";
  private static final String WHERE = "WHERE";
  private static final String TERMINATE = ";";
  private static final String SP = " ";

  @Override
  public String buildStatementByPlayerName(String playerName) {
    return String.format(SQL_SEARCH_NAME, playerName.toLowerCase());
  }

  @Override
  public String buildStatementByCriteria(SearchCriteria searchCriteria) {
    String result = START;
    Boolean flag = false;
    if (searchCriteria.getNation() != null) {
      result = result + SP + WHERE + SP + String.format(CLAUSE_NATION, searchCriteria.getNation());
      flag = true;
    }
    if (searchCriteria.getLeague() != null) {
      if (flag) {
        result = result + SP + AND + SP + String.format(CLAUSE_LEAGUE, searchCriteria.getLeague());
      } else {
        result = result + SP + WHERE + SP + String.format(CLAUSE_LEAGUE, searchCriteria.getLeague());
      }
      flag = true;
    }
    if (searchCriteria.getClub() != null) {
      if (flag) {
        result = result + SP + AND + SP + String.format(CLAUSE_CLUB, searchCriteria.getClub());
      } else {
        result = result + SP + WHERE + SP + String.format(CLAUSE_CLUB, searchCriteria.getClub());
      }
      flag = true;
    }
    if (searchCriteria.getPosition() != null) {
      if (flag) {
        result = result + SP + AND + SP + String.format(CLAUSE_POSITION, searchCriteria.getPosition().name());
      } else {
        result = result + SP + WHERE + SP + String.format(CLAUSE_POSITION, searchCriteria.getPosition().name());
      }
    }
    if (searchCriteria.getSortCriteria() != null) {
      result = result + SP + String.format(ORDER_BY, searchCriteria.getSortCriteria().getName());
    }
    result = result + TERMINATE;
    return result;
  }

  @Override
  public String buildStatementNationByFirstLetterInRange(Character start, Character end) {
    if (Character.isLetter(start)&& Character.isLetter(end)) {
      return String.format(SQL_SEARCH_NATION_START_WITH, Character.toLowerCase(start), Character.toLowerCase(end));
    } else {
      return String.format(SQL_SEARCH_NATION_START_WITH, 'a', 'z');
    }
  }

  @Override
  public String buildStatementLeagueByFirstLetterInRange(Character start, Character end) {
    if (Character.isLetter(start)&& Character.isLetter(end)) {
      return String.format(SQL_SEARCH_LEAGUE_START_WITH, Character.toLowerCase(start), Character.toLowerCase(end));
    } else {
      return String.format(SQL_SEARCH_LEAGUE_START_WITH, 'a', 'z');
    }
  }

  @Override
  public String buildStatementClubByLeague(String leagueName) {
    return String.format(SQL_SEARCH_CLUB_BY_LEAGUE, leagueName);
  }
}
