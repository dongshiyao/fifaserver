package ccs.neu.edu.cs5200.fifaserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.dao.gkdao.DivingDao;
import ccs.neu.edu.cs5200.fifaserver.model.player.goalkeeper.Diving;

@RestController
@RequestMapping("/player")
public class PlayerController {
  @RequestMapping(method = RequestMethod.GET, value = "/hello")
  public String sayHello() {
    return "Yes, hello from player";
  }

  @RequestMapping(method = RequestMethod.GET, value = "/readDiving")
  public List<Long> getDiving(int threshold) {
    return DivingDao.getInstance().getPlayersDivingOverallLargerThan(threshold);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createDiving")
  public String saveDiving(int acceleration, int sprintSpeed, int overall) {
    return String.format("Create a record with id = %d",
        DivingDao.getInstance().create(new Diving(1, acceleration, sprintSpeed, overall, 1)));
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/deleteDiving")
  public String deleteDiving(int statId) {
    return String.format("Delete a record with statid = %d",
        DivingDao.getInstance().deleteDivingByStatId(statId));
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/updateAcceleration")
  public String updateAcceleration(int statId, int acceleration) {
    return String.format("Update a record with statid = %d",
        DivingDao.getInstance().updateAcceleration(statId, acceleration));
  }

}
