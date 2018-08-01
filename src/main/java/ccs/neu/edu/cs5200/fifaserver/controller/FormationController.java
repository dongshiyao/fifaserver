package ccs.neu.edu.cs5200.fifaserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Formation;
import ccs.neu.edu.cs5200.fifaserver.service.squad.FormationService;

@RestController
@RequestMapping("/formation")
@CrossOrigin(origins = "http://localhost:3000")
public class FormationController {
  private final FormationService formationService;

  public FormationController(FormationService formationService) {
    this.formationService = formationService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/displayAllFormations")
  public List<String> displayAllFormations() {
    return formationService.displayAllFormationName();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createFormation")
  public ResponseEntity<String> createFormation(@RequestBody Formation formation) {
    try {
      formationService.createFormation(formation);
      return ResponseEntity.ok("Formation created successfully!");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
