package ccs.neu.edu.cs5200.fifaserver.service.squad;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ccs.neu.edu.cs5200.fifaserver.dao.player.PlayerRepository;
import ccs.neu.edu.cs5200.fifaserver.dao.squad.FormationRepository;
import ccs.neu.edu.cs5200.fifaserver.dao.squad.SquadPlayerJunctionRepository;
import ccs.neu.edu.cs5200.fifaserver.dao.squad.SquadRepository;
import ccs.neu.edu.cs5200.fifaserver.dao.squad.UserSquadJunctionRepository;
import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.Formation;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.PosNum;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.Position;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.Squad;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerKey;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.UserSquadJunction;

@Component("squadService")
@Transactional
public class SquadServiceImpl implements SquadService {
  private static final Integer ELEVEN = 11;
  private static final Integer ONE_HUNDRED = 100;
  private final SquadPlayerJunctionRepository squadPlayerJunctionRepository;
  private final SquadRepository squadRepository;
  private final UserSquadJunctionRepository userSquadJunctionRepository;
  private final PlayerRepository playerRepository;
  private final FormationRepository formationRepository;

  public SquadServiceImpl(SquadPlayerJunctionRepository squadPlayerJunctionRepository, SquadRepository squadRepository, UserSquadJunctionRepository userSquadJunctionRepository, PlayerRepository playerRepository, FormationRepository formationRepository) {
    this.squadPlayerJunctionRepository = squadPlayerJunctionRepository;
    this.squadRepository = squadRepository;
    this.userSquadJunctionRepository = userSquadJunctionRepository;
    this.playerRepository = playerRepository;
    this.formationRepository = formationRepository;
  }


  @Override
  public SquadPlayerJunction addPlayerToSquad(SquadPlayerJunction squadPlayerJunction) {
    if (squadPlayerJunctionRepository.existsById(new SquadPlayerKey(squadPlayerJunction.getSquadId(), squadPlayerJunction.getPlayerId()))) {
      throw new IllegalArgumentException("Duplicate Player in Squad!");
    }
    return squadPlayerJunctionRepository.save(squadPlayerJunction);
  }

  @Override
  public Squad readSquadInfo(Long squadId) {
    Optional<Squad> squadOptional = squadRepository.findById(squadId);
    return squadOptional.orElse(null);
  }

  @Override
  public void removePlayerFromSquad(SquadPlayerJunction squadPlayerJunction) {
    squadPlayerJunctionRepository.delete(squadPlayerJunction);
  }

  @Override
  public List<SquadPlayerJunction> displayPlayersInSquad(Long squadId) {
    return squadPlayerJunctionRepository.findBySquadId(squadId);
  }

  @Override
  public void removeSquad(UserSquadJunction userSquadJunction) {
    userSquadJunctionRepository.delete(userSquadJunction);
    squadPlayerJunctionRepository.removeBySquadId(userSquadJunction.getSquadId());
    squadRepository.deleteById(userSquadJunction.getSquadId());
  }

  @Override
  public String renameSquad(Long squadId, String newName) {
    squadRepository.setFixedSquadNameFor(newName, squadId);
    return newName;
  }

  @Override
  public Squad createSquad(String userName, String squadName, String formationName) {
    Squad squad = squadRepository.save(new Squad(squadName, formationName));
    userSquadJunctionRepository.save(new UserSquadJunction(userName, squad.getSquadId()));
    return squad;
  }

  @Override
  public List<Squad> displaySquadByUserName(String userName) {
    List<UserSquadJunction> userSquadJunctionList = userSquadJunctionRepository.findByUserName(userName);
    List<Squad> result = new ArrayList<>();
    for (UserSquadJunction userSquadJunction : userSquadJunctionList) {
      Optional<Squad> squadOptional= squadRepository.findById(userSquadJunction.getSquadId());
      result.add(squadOptional.orElse(null));
    }
    return result;
  }

  @Override
  public Integer calculateSquadRating(Long squadId) {
    Integer total = 0;
    List<SquadPlayerJunction> squadPlayerJunctionsList = squadPlayerJunctionRepository.findBySquadId(squadId);
    for (SquadPlayerJunction squadPlayerJunction : squadPlayerJunctionsList) {
      Optional<Player> playerOptional = playerRepository.findById(squadPlayerJunction.getPlayerId());
      if (playerOptional.isPresent()) {
        total = total + playerOptional.get().getOverall();
      }
    }
    Integer rating = total / ELEVEN;
    squadRepository.setFixedSquadRatingFor(rating, squadId);
    return rating;
  }

  public Integer calculateChemistry(Long squadId) {
    Integer total = 0;
    List<SquadPlayerJunction> squadPlayerJunctionsList = squadPlayerJunctionRepository.findBySquadId(squadId);
    Optional<Squad> squadOptional = squadRepository.findById(squadId);
    if (squadOptional.isPresent()) {
      Squad squad = squadOptional.get();
      Formation formation = formationRepository.findById(squad.getFormationName()).orElse(null);
      for (SquadPlayerJunction squadPlayerJunction : squadPlayerJunctionsList) {
        PosNum posNum = squadPlayerJunction.getPosNumber();
        Optional<Player> playerOptional = playerRepository.findById(squadPlayerJunction.getPlayerId());
        if (playerOptional.isPresent()) {
          total = total + comparePosition(formation, posNum, playerOptional.get().getPosition());
        }
      }
    }
    Integer chemistry = total * ONE_HUNDRED / ELEVEN;
    squadRepository.setFixedSquadChemistryFor(chemistry, squadId);
    return chemistry;
  }

  private Integer comparePosition(Formation formation, PosNum posNum, Position position) {
    Integer result;
    switch (posNum) {
      case ONE: result = (formation.getPos1().equals(position) ? 1 : 0); break;
      case TWO: result = (formation.getPos2().equals(position) ? 1 : 0); break;
      case THREE: result = (formation.getPos3().equals(position) ? 1 : 0); break;
      case FOUR: result = (formation.getPos4().equals(position) ? 1 : 0); break;
      case FIVE: result = (formation.getPos5().equals(position) ? 1 : 0); break;
      case SIX: result = (formation.getPos6().equals(position) ? 1 : 0); break;
      case SEVEN: result = (formation.getPos7().equals(position) ? 1 : 0); break;
      case EIGHT: result = (formation.getPos8().equals(position) ? 1 : 0); break;
      case NINE: result = (formation.getPos9().equals(position) ? 1 : 0); break;
      case TEN: result = (formation.getPos10().equals(position) ? 1 : 0); break;
      case ELEVEN: result = (formation.getPos11().equals(position) ? 1 : 0); break;
      default: result = 0;
    }
    return result;
  }
}
