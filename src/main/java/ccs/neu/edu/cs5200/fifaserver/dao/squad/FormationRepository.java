package ccs.neu.edu.cs5200.fifaserver.dao.squad;

import org.springframework.data.repository.CrudRepository;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Formation;

public interface FormationRepository extends CrudRepository<Formation, String> {
}
