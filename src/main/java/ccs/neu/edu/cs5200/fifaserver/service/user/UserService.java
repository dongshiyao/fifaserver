package ccs.neu.edu.cs5200.fifaserver.service.user;

import java.sql.Date;

import ccs.neu.edu.cs5200.fifaserver.domain.user.FreeUser;
import ccs.neu.edu.cs5200.fifaserver.domain.user.LoginPair;
import ccs.neu.edu.cs5200.fifaserver.domain.user.PremiumUser;
import ccs.neu.edu.cs5200.fifaserver.domain.user.User;

public interface UserService {
  /**
   * Check if username and password can be a valid pair for login.
   *
   * @param loginPair the login credential
   * @return true if login successfully, false otherwise
   */
  Boolean userLogin(LoginPair loginPair);

  /**
   * Create a new free user.
   *
   * @param user the free user to be created
   * @return message
   */
  String createFreeUser(User user);

  /**
   * Create a new premium user.
   *
   * @param user the premium user to be created
   * @param creditCardNum credit card number
   * @param creditCardExp credit card expiration date
   * @return message
   */
  String createPremiumUser(User user, Long creditCardNum, Date creditCardExp);

  /**
   * Find user by username.
   *
   * @param userName the username
   * @return user
   */
  User findUserByUserName(String userName);

  /**
   * Find free user by username.
   *
   * @param userName the username
   * @return free user
   */
  FreeUser findFreeUserByUserName(String userName);

  /**
   * Find premium user by username.
   *
   * @param userName the username
   * @return premium user
   */
  PremiumUser findPremiumUserByUserName(String userName);

  /**
   * Upgrade free user to premium if exists or increase vip level by 1 if the user is already premium.
   *
   * @param userName the username
   * @param creditCardNum credit card number
   * @param creditCardExp credit card expiration date
   * @return message
   */
  String upgradeUser(String userName, Long creditCardNum, Date creditCardExp);

  /**
   * Downgrade premium user to free user if exists.
   *
   * @param userName the username
   * @return message
   */
  String downgradeUser(String userName);

  /**
   * Update the user's email.
   *
   * @param userName the username
   * @param email the email to update to
   * @return username
   */
  String updateUserEmail(String userName, String email);

  /**
   * Update the user's password.
   *
   * @param userName the username
   * @param password the password to update to
   * @return username
   */
  String updateUserPassword(String userName, String password);

  /**
   * Delete the user by username.
   *
   * @param userName the username
   * @return username
   */
  String deleteUserByUserName(String userName);

}
