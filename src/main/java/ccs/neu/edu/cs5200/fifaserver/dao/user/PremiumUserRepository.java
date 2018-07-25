package ccs.neu.edu.cs5200.fifaserver.dao.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.sql.Date;

import ccs.neu.edu.cs5200.fifaserver.domain.user.PremiumUser;

public interface PremiumUserRepository extends CrudRepository<PremiumUser, String> {
  @Modifying
  @Query("update PremiumUser u set u.vipLevel = ?1 where u.userName = ?2")
  int setFixedVIPLevel(Integer vipLevel, String userName);

  @Modifying
  @Query("update PremiumUser u set u.vipExp = ?1 where u.userName = ?2")
  int setFixedVIPExp(Date vipExp, String userName);

  @Modifying
  @Query("update PremiumUser u set u.creditCardNum = ?1 where u.userName = ?2")
  int setFixedCreditCardNum(Long creditCardNum, String userName);

  @Modifying
  @Query("update PremiumUser u set u.creditCardExp = ?1 where u.userName = ?2")
  int setFixedCreditCardExp(Date creditCardExp, String userName);
}
