package edu.ntnu.idatt2105.trivium.repository;

import edu.ntnu.idatt2105.trivium.exception.user.UserAlreadyExistsException;
import edu.ntnu.idatt2105.trivium.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Optional;

@Repository
public class JdbcUserRepository implements UserRepository {

  @Autowired
  private JdbcClient client;

  @Override
  public void registerUser(String username, String password) {
    try {
      client.sql("INSERT INTO user (username, password) VALUES (:username, :password)")
          .param("username", username)
          .param("password", password)
          .update();
    } catch (DataAccessException e) {
      if (e.getCause() instanceof SQLException sqlException) {
        if (sqlException.getErrorCode() == 1062) {
          throw new UserAlreadyExistsException();
        }
      }
    }
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return client.sql("SELECT * FROM user WHERE username = :username")
        .param("username", username)
        .query(User.class)
        .optional();
  }
}