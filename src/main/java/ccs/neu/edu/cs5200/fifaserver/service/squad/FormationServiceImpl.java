package ccs.neu.edu.cs5200.fifaserver.service.squad;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import ccs.neu.edu.cs5200.fifaserver.dao.squad.FormationRepository;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.Formation;

@Component("formationService")
@Transactional
public class FormationServiceImpl implements FormationService {

  private final FormationRepository formationRepository;

  public FormationServiceImpl(FormationRepository formationRepository) {
    this.formationRepository = formationRepository;
  }

  @Override
  public List<String> displayAllFormationName() {
    return StreamSupport.stream(formationRepository.findAll().spliterator(), false)
                        .map((Formation::getFormationName))
                        .collect(Collectors.toList());
  }
}
