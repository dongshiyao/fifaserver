package ccs.neu.edu.cs5200.fifaserver.dao.player;

import org.springframework.stereotype.Component;

import ccs.neu.edu.cs5200.fifaserver.domain.player.SearchCriteria;

@Component("statementBuilder")
public class StatementBuilderImpl implements StatementBuilder {
  private static final String START = "SELECT c FROM Player c";
  private static final String SQL_SEARCH_NATION_START_WITH = "SELECT nation FROM Player WHERE %s GROUP BY nation ORDER BY nation";
  private static final String SQL_SEARCH_LEAGUE_START_WITH = "SELECT league FROM Player WHERE %s GROUP BY league ORDER BY league";
  private static final String SQL_SEARCH_CLUB_BY_LEAGUE = "SELECT club FROM Player WHERE league = '%s' GROUP BY club ORDER BY club";
  private static final String CLAUSE_PLAYER_NAME = "LOWER(player_name) LIKE '%%%s%%'";
  private static final String CLAUSE_NATION_LIKE = "LOWER(nation) LIKE '%c%%'";
  private static final String CLAUSE_LEAGUE_LIKE = "LOWER(league) LIKE '%c%%'";
  private static final String CLAUSE_NATION = "nation = '%s'";
  private static final String CLAUSE_LEAGUE = "league = '%s'";
  private static final String CLAUSE_CLUB = "club = '%s'";
  private static final String CLAUSE_POSITION = "pos = '%s'";
  private static final String ORDER_BY = "ORDER BY %s DESC";
  private static final String OR = "OR";
  private static final String AND = "AND";
  private static final String WHERE = "WHERE";
  private static final String SP = " ";
  private static final Character CHAR_A = 'a';
  private static final Character CHAR_Z = 'z';

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
        result =
            result + SP + WHERE + SP + String.format(CLAUSE_LEAGUE, searchCriteria.getLeague());
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
        result = result + SP + AND + SP
            + String.format(CLAUSE_POSITION, searchCriteria.getPosition().name());
      } else {
        result = result + SP + WHERE + SP
            + String.format(CLAUSE_POSITION, searchCriteria.getPosition().name());
      }
      flag = true;
    }
    if (searchCriteria.getPlayerName() != null) {
      if (flag) {
        result = result + SP + AND + SP
            + String.format(CLAUSE_PLAYER_NAME, searchCriteria.getPlayerName());
      } else {
        result = result + SP + WHERE + SP
            + String.format(CLAUSE_PLAYER_NAME, searchCriteria.getPlayerName());
      }
    }
    if (searchCriteria.getSortCriteria() != null) {
      result = result + SP + String.format(ORDER_BY, searchCriteria.getSortCriteria().getName());
    }
    return result;
  }

  @Override
  public String buildStatementNationByFirstLetterInRange(Character start, Character end) {
    start = Character.toLowerCase(start);
    end = Character.toLowerCase(end);
    if (Character.isLetter(start) && Character.isLetter(end) && start < end) {
      return String.format(SQL_SEARCH_NATION_START_WITH, helperBuildNationLike(start, end));
    } else {
      return String.format(SQL_SEARCH_NATION_START_WITH, helperBuildNationLike(CHAR_A, CHAR_Z));
    }
  }

  @Override
  public String buildStatementLeagueByFirstLetterInRange(Character start, Character end) {
    start = Character.toLowerCase(start);
    end = Character.toLowerCase(end);
    if (Character.isLetter(start) && Character.isLetter(end) && start < end) {
      return String.format(SQL_SEARCH_LEAGUE_START_WITH, helperBuildLeagueLike(start, end));
    } else {
      return String.format(SQL_SEARCH_LEAGUE_START_WITH, helperBuildLeagueLike(CHAR_A, CHAR_Z));
    }
  }

  @Override
  public String buildStatementClubByLeague(String leagueName) {
    return String.format(SQL_SEARCH_CLUB_BY_LEAGUE, leagueName);
  }

  private String helperBuildNationLike(Character start, Character end) {
    StringBuilder result = new StringBuilder();
    for (Character c = start; c <= end; c++) {
      if (c.equals(start)) {
        result.append(String.format(CLAUSE_NATION_LIKE, c));
      } else {
        result.append(SP).append(OR).append(SP).append(String.format(CLAUSE_NATION_LIKE, c));
      }
    }
    return result.toString();
  }

  private String helperBuildLeagueLike(Character start, Character end) {
    StringBuilder result = new StringBuilder();
    for (Character c = start; c <= end; c++) {
      if (c.equals(start)) {
        result.append(String.format(CLAUSE_LEAGUE_LIKE, c));
      } else {
        result.append(SP).append(OR).append(SP).append(String.format(CLAUSE_LEAGUE_LIKE, c));
      }
    }
    return result.toString();
  }
}
