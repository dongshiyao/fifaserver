package ccs.neu.edu.cs5200.fifaserver.service.squad;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Squad;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.UserSquadJunction;

public interface SquadService {
  SquadPlayerJunction addPlayerToSquad(SquadPlayerJunction squadPlayerJunction);

  Squad readSquadInfo(Long squadId);

  void removePlayerFromSquad(SquadPlayerJunction squadPlayerJunction);

  List<SquadPlayerJunction> displayPlayersInSquad(Long squadId);

  void removeSquad(UserSquadJunction userSquadJunction);

  String renameSquad(Long squadId, String newName);

  Squad createSquad(String userName, String squadName, String formationName);

  List<Squad> displaySquadByUserName(String userName);

  Integer calculateSquadRating(Long squadId);

  Integer calculateChemistry(Long squadId);
}
