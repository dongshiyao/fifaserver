package ccs.neu.edu.cs5200.fifaserver.dao.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ccs.neu.edu.cs5200.fifaserver.domain.user.User;

public interface FreeUserRepository extends CrudRepository<User, Integer> {
  @Modifying
  @Query("update FreeUser u set u.searchCredit = ?1 where u.userId = ?2")
  int setFixedSearchCredit(Integer searchCredit, Long userId);


}
