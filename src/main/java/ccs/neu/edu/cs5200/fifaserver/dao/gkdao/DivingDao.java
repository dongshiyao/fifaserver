package ccs.neu.edu.cs5200.fifaserver.dao.gkdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import ccs.neu.edu.cs5200.fifaserver.model.player.goalkeeper.Diving;
import ccs.neu.edu.cs5200.fifaserver.util.DBConnectionPool;

public class DivingDao {
  private DBConnectionPool dbConnectionPool;
  private static DivingDao divingDao = null;

  private DivingDao() {
    dbConnectionPool = DBConnectionPool.getInstance();
  }

  public static DivingDao getInstance() {
    if (divingDao == null) {
      divingDao = new DivingDao();
    }
    return divingDao;
  }

  public int create(Diving diving) {
    String insertDiving = "INSERT INTO Diving (Acceleration, SprintSpeed, Overall, StatID) VALUES(?, ?, ?, ?);";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    int candidateId = 0;
    try {
      connection = dbConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(insertDiving, Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setInt(1, diving.getAcceleration());
      preparedStatement.setInt(2, diving.getSprintSpeed());
      preparedStatement.setInt(3, diving.getOverall());
      preparedStatement.setLong(4, diving.getGkStatId());
      int rowAffected = preparedStatement.executeUpdate();
      if (rowAffected == 1) {
        ResultSet resultSet = preparedStatement.getGeneratedKeys();
        if (resultSet.next()) {
          candidateId = resultSet.getInt(1);
        }
      }
      return candidateId;
    } catch (Exception e) {
      Logger.getLogger(DivingDao.class.getName()).log(Level.SEVERE, e.getMessage(), e);
      return candidateId;
    } finally {
      dbConnectionPool.closeConnection(connection, preparedStatement);
    }
  }

  public int updateAcceleration(int statId, int acceleration) {
    String updateAcceleration = "UPDATE Diving SET Acceleration = ? WHERE StatID = ?;";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = dbConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(updateAcceleration);
      preparedStatement.setInt(1, acceleration);
      preparedStatement.setLong(2, statId);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      Logger.getLogger(DivingDao.class.getName()).log(Level.SEVERE, e.getMessage(), e);
      return 0;
    } finally {
      dbConnectionPool.closeConnection(connection, preparedStatement);
    }
    return statId;
  }

  public int updateSprintSpeed(int statId, int sprintSpeed) {
    String updateSprintSpeed = "UPDATE Diving SET SprintSpeed = ? WHERE StatID = ?;";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = dbConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(updateSprintSpeed);
      preparedStatement.setInt(1, sprintSpeed);
      preparedStatement.setLong(2, statId);
      preparedStatement.executeUpdate();
    } catch (Exception e) {
      Logger.getLogger(DivingDao.class.getName()).log(Level.SEVERE, e.getMessage(), e);
      return 0;
    } finally {
      dbConnectionPool.closeConnection(connection, preparedStatement);
    }
    return statId;
  }

  public List<Long> getPlayersDivingOverallLargerThan(int threshold) {
    String getOverall = "SELECT * FROM Diving WHERE Overall > ?";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    List<Long> result = new ArrayList<>();
    try {
      connection = dbConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(getOverall);
      preparedStatement.setInt(1, threshold);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        long statId = resultSet.getLong("StatID");
        result.add(statId);
      }
    } catch (Exception e) {
      Logger.getLogger(DivingDao.class.getName()).log(Level.SEVERE, e.getMessage(), e);
    } finally {
      dbConnectionPool.closeConnection(connection, preparedStatement);
    }
    return result;
  }
}
