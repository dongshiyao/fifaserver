package ccs.neu.edu.cs5200.fifaserver.service.player;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import ccs.neu.edu.cs5200.fifaserver.dao.player.PlayerDao;
import ccs.neu.edu.cs5200.fifaserver.dao.player.PlayerRepository;
import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;
import ccs.neu.edu.cs5200.fifaserver.domain.player.SearchCriteria;
import ccs.neu.edu.cs5200.fifaserver.domain.player.SortCriteria;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.Position;

@Component("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService {

  private static final String NULL_INPUT = "NULL_INPUT";

  private final PlayerDao playerDao;
  private final PlayerRepository playerRepository;

  public PlayerServiceImpl(PlayerDao playerDao, PlayerRepository playerRepository) {
    this.playerDao = playerDao;
    this.playerRepository = playerRepository;
  }

  @Override
  public List<Player> searchByPlayerName(String playerName) {
    return playerDao.searchByPlayerName(playerName);
  }

  @Override
  public List<Player> searchByPlayerCriteria(String nation, String league, String club,
                                             String position, String sortCriteria) {
    SearchCriteria searchCriteria = new SearchCriteria();
    if (!nation.equals(NULL_INPUT)) {
      searchCriteria.setNation(nation);
    }
    if (!league.equals(NULL_INPUT)) {
      searchCriteria.setLeague(league);
    }
    if (!club.equals(NULL_INPUT)) {
      searchCriteria.setClub(club);
    }
    if (!position.equals(NULL_INPUT)) {
      searchCriteria.setPosition(Position.valueOf(position));
    }
    if (!sortCriteria.equals(NULL_INPUT)) {
      searchCriteria.setSortCriteria(SortCriteria.valueOf(sortCriteria));
    }
    return playerDao.searchByCriteria(searchCriteria);
  }

  @Override
  public List<String> displayNationByFirstLetterInRange(Character start, Character end) {
    return playerDao.searchNationByFirstLetterInRange(start, end);
  }

  @Override
  public List<String> displayLeagueByFirstLetterInRange(Character start, Character end) {
    return playerDao.searchLeagueByFirstLetterInRange(start, end);
  }

  @Override
  public List<String> displayClubByLeagueName(String leagueName) {
    return playerDao.searchClubByLeague(leagueName);
  }

  @Override
  public Player searchByPlayerId(Long playerId) {
    Optional<Player> playerOptional = playerRepository.findById(playerId);
    return playerOptional.orElse(null);
  }
}
