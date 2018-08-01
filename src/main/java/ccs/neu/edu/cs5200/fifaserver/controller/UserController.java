package ccs.neu.edu.cs5200.fifaserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ccs.neu.edu.cs5200.fifaserver.domain.user.FreeUser;
import ccs.neu.edu.cs5200.fifaserver.domain.user.LoginPair;
import ccs.neu.edu.cs5200.fifaserver.domain.user.PremInput;
import ccs.neu.edu.cs5200.fifaserver.domain.user.PremiumUser;
import ccs.neu.edu.cs5200.fifaserver.domain.user.UpgradeInput;
import ccs.neu.edu.cs5200.fifaserver.domain.user.User;
import ccs.neu.edu.cs5200.fifaserver.service.user.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

  @Autowired
  private final UserService userService;


  public UserController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/userLogin")
  public ResponseEntity<String> userLogin(@RequestBody LoginPair loginPair) {
    if (userService.userLogin(loginPair)) {
      return ResponseEntity.ok("Login Successfully!");
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid username or password!");
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/findUserByUserName")
  public User findUserByUserName(@RequestParam(name = "user_name") String userName) {
    return userService.findUserByUserName(userName);
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createFreeUser")
  public ResponseEntity<String> createFreeUser(@RequestBody User user) {
    try {
      String result = userService.createFreeUser(user);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.POST, value = "/createPremiumUser")
  public ResponseEntity<String> createPremiumUser(@RequestBody PremInput premInput) {
    try {
      String result = userService.createPremiumUser(premInput.buildUser(), premInput.getCreditCardNum(),
          premInput.getCreditCardExp());
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.GET, value = "/findFreeUserByUserName")
  public FreeUser findFreeUserByUserName(@RequestParam(name = "user_name") String userName) {
    return userService.findFreeUserByUserName(userName);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/findPremiumUserByUserName")
  public PremiumUser findPremiumUserByUserName(@RequestParam(name = "user_name") String userName) {
    return userService.findPremiumUserByUserName(userName);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/upgradeUser")
  public ResponseEntity<String> upgradeUser(@RequestBody UpgradeInput upgradeInput) {
    try {
      String result = userService.upgradeUser(upgradeInput.getUserName(), upgradeInput.getCreditCardNum(),
          upgradeInput.getCreditCardExp());
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/downgradeUser")
  public ResponseEntity<String> downgradeUser(@RequestParam(name = "user_name") String userName) {
    try {
      String result = userService.downgradeUser(userName);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/updateEmail")
  public ResponseEntity<String> upgradeEmail(@RequestParam(name = "user_name") String userName,
                                             @RequestParam(name = "email") String email) {
    try {
      String result = userService.updateUserEmail(userName, email);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/updatePassword")
  public ResponseEntity<String> upgradePassword(@RequestParam(name = "user_name") String userName,
                                                @RequestBody String password) {
    try {
      String result = userService.updateUserPassword(userName, password);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
  public ResponseEntity<String> deleteUser(@RequestParam(name = "user_name") String userName) {
    try {
      String result = userService.deleteUserByUserName(userName);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }
}
