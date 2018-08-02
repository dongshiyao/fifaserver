package ccs.neu.edu.cs5200.fifaserver.controller;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.squad.Squad;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.SquadPlayerJunction;
import ccs.neu.edu.cs5200.fifaserver.domain.squad.UserSquadJunction;
import ccs.neu.edu.cs5200.fifaserver.service.squad.SquadService;

@RestController
@RequestMapping("/squad")
@CrossOrigin(origins = "http://localhost:3000")
public class SquadController {
  private final SquadService squadService;

  public SquadController(SquadService squadService) {
    this.squadService = squadService;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/addPlayerToSquad")
  public ResponseEntity<String> addPlayerToSquad(@RequestBody SquadPlayerJunction squadPlayerJunction) {
    try {
      Long squadId = squadPlayerJunction.getSquadId();
      squadService.addPlayerToSquad(squadPlayerJunction);
      squadService.calculateSquadRating(squadId);
      squadService.calculateChemistry(squadId);
      return ResponseEntity.ok("Player has been successfully added!");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/readSquadInfoBySquadId")
  public Squad readSquadInfoBySquadId(@RequestParam(name = "squad_id", defaultValue = "0")Long squadId) {
    return squadService.readSquadInfo(squadId);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/removePlayerFromSquad")
  public ResponseEntity<String> removePlayerFromSquad(@RequestBody SquadPlayerJunction squadPlayerJunction) {
    try {
      Long squadId = squadPlayerJunction.getSquadId();
      squadService.removePlayerFromSquad(squadPlayerJunction);
      squadService.calculateSquadRating(squadId);
      squadService.calculateChemistry(squadId);
      return ResponseEntity.ok("Player has been successfully removed from squad!");
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status((HttpStatus.BAD_REQUEST)).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/displayPlayersInSquad")
  public List<SquadPlayerJunction> displayPlayersInSquad(@RequestParam(name = "squad_id", defaultValue = "0") Long squadId) {
    return squadService.displayPlayersInSquad(squadId);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/removeSquad")
  public ResponseEntity<String> removeSquad(@RequestParam(name = "user_name", defaultValue = "0")String userName,
                                            @RequestParam(name = "squad_id", defaultValue = "0") Long squadId) {
    try {
      squadService.removeSquad(new UserSquadJunction(userName, squadId));
      return ResponseEntity.ok(String.format("Squad [%d] of User [%s] has been successfully removed!", squadId, userName));
    } catch (EmptyResultDataAccessException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Squad does not exist!");
    }
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/renameSquad")
  public ResponseEntity<String> renameSquad(@RequestParam(name = "squad_id") Long squadId, @RequestParam(name = "new_squad_name") String newName) {
    try {
      return ResponseEntity.ok(String.format("New name %s updated successfully!",squadService.renameSquad(squadId, newName)));
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createSquad")
  public ResponseEntity<Squad> createSquad(@RequestParam(name = "user_name") String userName,
                                            @RequestParam(name = "squad_name") String squadName,
                                            @RequestParam(name = "formation_name") String formationName) {
    try {
      Squad squad = squadService.createSquad(userName, squadName, formationName);
      return ResponseEntity.ok(squad);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/displaySquadByUserName")
  public List<Squad> displaySquadByUserName(@RequestParam(name = "user_name") String userName) {
    return squadService.displaySquadByUserName(userName);
  }

//  @RequestMapping(method = RequestMethod.GET, value = "/getSquadRating")
//  public Integer getSquadRating(@RequestParam(name = "squad_id") Long squadId) {
//    return squadService.calculateSquadRating(squadId);
//  }
//
//  @RequestMapping(method = RequestMethod.GET, value = "/getSquadChemistry")
//  public Integer getSquadChemistry(@RequestParam(name = "squad_id") Long squadId) {
//    return squadService.calculateChemistry(squadId);
//  }
}
