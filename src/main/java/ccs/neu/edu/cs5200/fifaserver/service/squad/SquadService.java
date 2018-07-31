package ccs.neu.edu.cs5200.fifaserver.service.squad;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Squad;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.UserSquadJunction;

public interface SquadService {
  /**
   * Add the player to squad.
   *
   * @param squadPlayerJunction squad player conjunction
   * @return the real conjunction in db
   */
  SquadPlayerJunction addPlayerToSquad(SquadPlayerJunction squadPlayerJunction);

  /**
   * Get the squad basic info.
   *
   * @param squadId the squad id
   * @return the squad
   */
  Squad readSquadInfo(Long squadId);

  /**
   * Remove player from squad.
   *
   * @param squadPlayerJunction squad player conjunction to remove
   */
  void removePlayerFromSquad(SquadPlayerJunction squadPlayerJunction);

  /**
   * Display players in the squad.
   *
   * @param squadId the squad id
   * @return the list of squad player conjunction
   */
  List<SquadPlayerJunction> displayPlayersInSquad(Long squadId);

  /**
   * Remove squad.
   *
   * @param userSquadJunction user squad conjunction
   */
  void removeSquad(UserSquadJunction userSquadJunction);

  /**
   * Rename the squad.
   *
   * @param squadId squad id
   * @param newName new squad name
   * @return new name
   */
  String renameSquad(Long squadId, String newName);

  /**
   * Create new squad.
   *
   * @param userName username
   * @param squadName squad name
   * @param formationName formation name
   * @return the new squad
   */
  Squad createSquad(String userName, String squadName, String formationName);

  /**
   * Display squad of a user.
   *
   * @param userName the username
   * @return list of squad
   */
  List<Squad> displaySquadByUserName(String userName);

  /**
   * Calculate the squad rating.
   *
   * @param squadId squad id
   * @return the rating
   */
  Integer calculateSquadRating(Long squadId);

  /**
   * Calculate the chemistry.
   *
   * @param squadId squad id
   * @return the chemistry
   */
  Integer calculateChemistry(Long squadId);
}
