package ccs.neu.edu.cs5200.fifaserver.service.user;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import ccs.neu.edu.cs5200.fifaserver.dao.user.FreeUserRepository;
import ccs.neu.edu.cs5200.fifaserver.dao.user.PremiumUserRepository;
import ccs.neu.edu.cs5200.fifaserver.dao.user.UserRepository;
import ccs.neu.edu.cs5200.fifaserver.domain.user.FreeUser;
import ccs.neu.edu.cs5200.fifaserver.domain.user.LoginPair;
import ccs.neu.edu.cs5200.fifaserver.domain.user.PremiumUser;
import ccs.neu.edu.cs5200.fifaserver.domain.user.User;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final FreeUserRepository freeUserRepository;
  private final PremiumUserRepository premiumUserRepository;

  private static final Integer DEFAULT_SEARCH_CREDIT = 100;
  private static final Integer DEFAULT_VIP_DURATION = 1;
  private static final Integer DEFAULT_VIP_LEVEL = 1;
  private static final Integer DEFAULT_VIP_SUBSCRIBE = 1;

  public UserServiceImpl(UserRepository userRepository, FreeUserRepository freeUserRepository,
                         PremiumUserRepository premiumUserRepository) {
    this.userRepository = userRepository;
    this.freeUserRepository = freeUserRepository;
    this.premiumUserRepository = premiumUserRepository;
  }

  @Override
  public User userLogin(LoginPair loginPair) {
    String userName = loginPair.getUserName();
    String password = loginPair.getPassword();
    Optional<User> userOptional = userRepository.findById(userName);
    if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
      return userOptional.get();
    } else {
      return null;
    }
  }

  @Override
  public String createFreeUser(User user) throws IllegalArgumentException {
    String username = user.getUserName();
    if (!userRepository.existsById(username)) {
      FreeUser freeUser = new FreeUser(user.getUserName(), user.getPassword(), user.getEmail(),
          DEFAULT_SEARCH_CREDIT);
      freeUserRepository.save(freeUser);
      return String.format("New free user[%s] with %d search credits", username, DEFAULT_SEARCH_CREDIT);
    } else {
      throw new IllegalArgumentException(String.format("UserName[%s] already exists!", username));
    }
  }

  @Override
  public String createPremiumUser(User user, Long creditCardNum, Date creditCardExp)
      throws IllegalArgumentException {
    String username = user.getUserName();
    if (!userRepository.existsById(username)) {
      Date vipExp = Date.valueOf(LocalDate.now().plusYears(DEFAULT_VIP_DURATION));
      PremiumUser premiumUser = new PremiumUser(user.getUserName(), user.getPassword(),
          user.getEmail(), vipExp, DEFAULT_VIP_LEVEL, creditCardNum, creditCardExp);
      premiumUserRepository.save(premiumUser);
      return String.format("New premium user[%s] valid for %d year with VIP Level %d", user.getUserName(),
          DEFAULT_VIP_DURATION,
          DEFAULT_VIP_LEVEL);
    } else {
      throw new IllegalArgumentException(String.format("UserName[%s] already exists!", username));
    }
  }

  @Override
  public User findUserByUserName(String userName) {
    Optional<User> userOptional = userRepository.findById(userName);
    return userOptional.orElse(null);
  }

  @Override
  public FreeUser findFreeUserByUserName(String userName) {
    Optional<FreeUser> freeUserOptional = freeUserRepository.findById(userName);
    return freeUserOptional.orElse(null);
  }

  @Override
  public PremiumUser findPremiumUserByUserName(String userName) {
    Optional<PremiumUser> premiumUserOptional = premiumUserRepository.findById(userName);
    return premiumUserOptional.orElse(null);
  }

  @Override
  public String upgradeUser(String userName, Long creditCardNum, Date creditCardExp)
      throws IllegalArgumentException {
    if (!userRepository.existsById(userName)) {
      throw new IllegalArgumentException(String.format("UserName[%s] does not exist!", userName));
    }
    Optional<User> userOptional = userRepository.findById(userName);
    User user = userOptional.orElse(null);
    if (freeUserRepository.existsById(userName)) {
      freeUserRepository.deleteById(userName);
    }
    Optional<PremiumUser> premiumUserOptional = premiumUserRepository.findById(userName);
    PremiumUser premiumUser;
    if (premiumUserOptional.isPresent()) {
      premiumUser = premiumUserOptional.get();
      Integer vipLevel = premiumUser.getVipLevel() + DEFAULT_VIP_SUBSCRIBE;
      premiumUserRepository.setFixedCreditCardExp(creditCardExp, userName);
      premiumUserRepository.setFixedCreditCardNum(creditCardNum, userName);
      premiumUserRepository.setFixedVIPLevel(vipLevel, userName);
      return String.format("User[%s] Upgrade to VIP Level %d", userName, vipLevel);
    } else {
      Date vipExp = Date.valueOf(LocalDate.now().plusYears(DEFAULT_VIP_DURATION));
      premiumUser = new PremiumUser(user.getUserName(), user.getPassword(), user.getEmail(),
          vipExp, DEFAULT_VIP_LEVEL, creditCardNum, creditCardExp);
      premiumUserRepository.save(premiumUser);
      return String.format("User[%s] Upgrade to Premium User with VIP Level %d Valid for %d year",
          userName, DEFAULT_VIP_LEVEL, DEFAULT_VIP_DURATION);
    }
  }

  @Override
  public String downgradeUser(String userName) throws IllegalArgumentException {
    if (!userRepository.existsById(userName)) {
      throw new IllegalArgumentException(String.format("UserName[%s] does not exist!", userName));
    }
    Optional<User> userOptional = userRepository.findById(userName);
    User user = userOptional.orElse(null);
    if (premiumUserRepository.existsById(userName)) {
      premiumUserRepository.deleteById(userName);
    }
    if (freeUserRepository.existsById(userName)) {
      return String.format("User[%s] is already free user, cannot be downgraded anymore!", userName);
    } else {
      freeUserRepository.save(new FreeUser(user.getUserName(), user.getPassword(), user.getEmail(), DEFAULT_SEARCH_CREDIT));
      return String.format("User[%s] has been downgraded to free user!", userName);
    }
  }

  @Override
  public String updateUserEmail(String userName, String email) throws IllegalArgumentException {
    if (!userRepository.existsById(userName)) {
      throw new IllegalArgumentException(String.format("UserName[%s] does not exist!", userName));
    }
    userRepository.setFixedEmailFor(email, userName);
    return String.format("Email address has been updated for User[%s]!", userName);
  }

  @Override
  public String updateUserPassword(String userName, String password) throws IllegalArgumentException {
    if (!userRepository.existsById(userName)) {
      throw new IllegalArgumentException(String.format("UserName[%s] does not exist!", userName));
    }
    userRepository.setFixedPasswordFor(password, userName);
    return String.format("Password has been updated for User[%s]", userName);
  }

  @Override
  public String deleteUserByUserName(String userName) throws EmptyResultDataAccessException {
    userRepository.deleteById(userName);
    return String.format("User[%s] has been deleted!", userName);
  }
}
