package ccs.neu.edu.cs5200.fifaserver.service.player;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;

public interface PlayerService {
  /**
   * Search all players who met the criteria.
   *
   * @param playerName the playerName
   * @param nation the nationality of player
   * @param league the league of player
   * @param club the club of player
   * @param position the position of player
   * @param sortCriteria the sort criteria of player
   * @return list of players
   */
  List<Player> searchByPlayerCriteria(String playerName, String nation, String league, String club, String position, String sortCriteria);

  /**
   * Retrieve all nations with name's first letter in range.
   *
   * @param start the start letter
   * @param end the end letter
   * @return list of nation names
   */
  List<String> displayNationByFirstLetterInRange(Character start, Character end);

  /**
   * Retrieve all leagues with name's first letter in range.
   *
   * @param start the start letter
   * @param end the end letter
   * @return list of league names
   */
  List<String> displayLeagueByFirstLetterInRange(Character start, Character end);

  /**
   * Retrieve all clubs by league name.
   *
   * @param leagueName the league name
   * @return list of club names
   */
  List<String> displayClubByLeagueName(String leagueName);

  /**
   * Search player by id.
   *
   * @param playerId the player id
   * @return player
   */
  Player searchByPlayerId(Long playerId);
}
