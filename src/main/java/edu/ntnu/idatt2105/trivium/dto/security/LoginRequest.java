package edu.ntnu.idatt2105.trivium.dto.security;

public class LoginRequest {

  private String username;
  private String password;

  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }
}