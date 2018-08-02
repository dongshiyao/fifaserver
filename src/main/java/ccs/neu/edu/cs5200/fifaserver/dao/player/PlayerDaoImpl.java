package ccs.neu.edu.cs5200.fifaserver.dao.player;

import org.springframework.stereotype.Component;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;
import ccs.neu.edu.cs5200.fifaserver.domain.player.SearchCriteria;

@Component("playerDao")
public class PlayerDaoImpl implements PlayerDao {

  @PersistenceContext
  private EntityManager entityManager;

  private final StatementBuilder statementBuilder;

  public PlayerDaoImpl(StatementBuilder statementBuilder) {
    this.statementBuilder = statementBuilder;
  }

  @Override
  public List<Player> searchByCriteria(SearchCriteria searchCriteria) {
    return entityManager.createQuery(statementBuilder.buildStatementByCriteria(searchCriteria),
        Player.class).getResultList();
  }

  @Override
  public List<String> searchNationByFirstLetterInRange(Character start, Character end) {
    return entityManager.createQuery(statementBuilder.buildStatementNationByFirstLetterInRange(start, end),
        String.class).getResultList();
  }

  @Override
  public List<String> searchLeagueByFirstLetterInRange(Character start, Character end) {
    return entityManager.createQuery(statementBuilder.buildStatementLeagueByFirstLetterInRange(start, end),
        String.class).getResultList();
  }

  @Override
  public List<String> searchClubByLeague(String leagueName) {
    return entityManager.createQuery(statementBuilder.buildStatementClubByLeague(leagueName),
        String.class).getResultList();

  }
}
