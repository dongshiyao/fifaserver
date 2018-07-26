package ccs.neu.edu.cs5200.fifaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.player.Player;
import ccs.neu.edu.cs5200.fifaserver.service.player.PlayerService;


@RestController
@RequestMapping("/players")
public class PlayerController {
  private static final String NULL_INPUT = "NULL_INPUT";
  private final PlayerService playerService;

  @Autowired
  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }

  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  public String sayHello(@RequestParam(name = "test", defaultValue = "null") Character msg) {
    if (msg.equals('n')) {
      return "Yes, hello from player";
    } else {
      return "Yes, hello to " + msg;
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/searchPlayerByName")
  public List<Player> searchPlayerByName(@RequestParam(name = "input_player_name") String playerName) {
    return playerService.searchByPlayerName(playerName);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/displayNationByFirstLetterInRange")
  public List<String> displayNationByFirstLetterInRange(@RequestParam(name = "start_letter", defaultValue = "a") Character startLetter,
                                                       @RequestParam(name = "end_letter", defaultValue = "z") Character endLetter) {
    return playerService.displayNationByFirstLetterInRange(startLetter, endLetter);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/displayLeagueByFirstLetterInRange")
  public List<String> displayLeagueByFirstLetterInRange(@RequestParam(name = "start_letter", defaultValue = "a") Character startLetter,
                                                       @RequestParam(name = "end_letter", defaultValue = "z") Character endLetter) {
    return playerService.displayLeagueByFirstLetterInRange(startLetter, endLetter);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/searchClubByLeagueName")
  public List<String> searchClubByLeague(@RequestParam(name = "league") String leagueName) {
    return playerService.displayClubByLeagueName(leagueName);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/searchPlayerByCriteria")
  public List<Player> searchPlayerByCriteria(@RequestParam(name = "nation", defaultValue = NULL_INPUT) String nation,
                                             @RequestParam(name = "league", defaultValue = NULL_INPUT) String league,
                                             @RequestParam(name = "club", defaultValue = NULL_INPUT) String club,
                                             @RequestParam(name = "position", defaultValue = NULL_INPUT) String position,
                                             @RequestParam(name = "sortCriteria", defaultValue = NULL_INPUT) String sortCriteria) {
    return playerService.searchByPlayerCriteria(nation, league, club, position, sortCriteria);
  }
}
