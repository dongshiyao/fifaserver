package ccs.neu.edu.cs5200.fifaserver.service.squad;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Formation;

public interface FormationService {
  /**
   * Get all available formations.
   *
   * @return list of formations
   */
  List<String> displayAllFormationName();

  /**
   * Create new formation.
   *
   * @param formation new formation
   * @return formation from db
   */
  Formation createFormation(Formation formation);
}
