package ccs.neu.edu.cs5200.fifaserver.dao.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import ccs.neu.edu.cs5200.fifaserver.domain.user.User;

public interface UserRepository extends CrudRepository<User, Integer> {

  List<User> findByUserName(String userName);

  List<User> removeByUserName(String userName);

  @Modifying
  @Query("update User u set u.password = ?1 where u.userName = ?2")
  int setFixedPasswordFor(String passWord, String userName);
}
