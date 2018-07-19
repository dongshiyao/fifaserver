package ccs.neu.edu.cs5200.fifaserver.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class DBConnectionPool {
  private static final String SQL_ENDPOINT = "localhost";
  private static final String SQL_PORT = "3306";
  private static final String SQL_DB_NAME = "ProjectFIFA";
  private static final String URL = String.format("jdbc:mysql://%s:%s/%s?autoReconnect=true&useSSL=false", SQL_ENDPOINT, SQL_PORT, SQL_DB_NAME);
  private static final String USERNAME = "root";
  private static final String PASSWORD = "123456";

  private BoneCP connectionPool;
  private static DBConnectionPool dbConnectionPool = new DBConnectionPool();

  private DBConnectionPool() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      BoneCPConfig cpConfig = new BoneCPConfig();
      cpConfig.setJdbcUrl(URL);
      cpConfig.setUsername(USERNAME);
      cpConfig.setPassword(PASSWORD);
      cpConfig.setMinConnectionsPerPartition(5);
      cpConfig.setMaxConnectionsPerPartition(10);
      cpConfig.setPartitionCount(1);
      connectionPool = new BoneCP(cpConfig);
    } catch (Exception e) {
      Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, e.getMessage(), e);
    }
  }

  public Connection getConnection() throws SQLException {
    return connectionPool.getConnection();
  }

  public static DBConnectionPool getInstance() {
    return dbConnectionPool;
  }

  public void closeConnection(Connection connection, PreparedStatement preparedStatement) {
    try {
      if (connection != null) {
        connection.close();
      }

      if (preparedStatement != null) {
        preparedStatement.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    DBConnectionPool dbConnectionPool = DBConnectionPool.getInstance();
    String getAll = "SELECT COUNT(*) FROM Player;";
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    try {
      connection = dbConnectionPool.getConnection();
      preparedStatement = connection.prepareStatement(getAll);
      ResultSet resultSet = preparedStatement.executeQuery();
      int counter = 0;
      while (resultSet.next()) {
        counter += 1;
        System.out.println(resultSet.getInt(1));
      }
      System.out.print(counter);
    } catch (Exception e) {
      Logger.getLogger(DBConnectionPool.class.getName()).log(Level.SEVERE, e.getMessage(), e);
    } finally {
      dbConnectionPool.closeConnection(connection, preparedStatement);
    }
  }
}
