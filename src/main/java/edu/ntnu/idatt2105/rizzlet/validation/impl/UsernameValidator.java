package edu.ntnu.idatt2105.rizzlet.validation.impl;

import edu.ntnu.idatt2105.rizzlet.properties.UserProperties;
import edu.ntnu.idatt2105.rizzlet.validation.Username;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * Validator for the Username constraint.
 * This validator ensures that a username meets the specified
 * criteria defined in the application properties.
 */
public final class UsernameValidator implements ConstraintValidator<Username, String> {

  private Pattern pattern;

  /**
   * Initializes the validator.
   *
   * @param username The Username annotation.
   */
  @Override
  public void initialize(Username username) {
    if (pattern == null) {
      pattern = Pattern.compile(UserProperties.NAME_REGEX);
    }
  }

  /**
   * Validates a username.
   *
   * @param username The username to validate.
   * @param context The constraint validator context.
   * @return true if the username is valid, false otherwise.
   */
  @Override
  public boolean isValid(String username, ConstraintValidatorContext context) {
    String message = null;
    if (username == null) {
      message = UserProperties.NAME_EMPTY;
    } else if (username.length() < UserProperties.NAME_LEN_MIN || username.length() > UserProperties.NAME_LEN_MAX) {
      message = UserProperties.NAME_LEN_MSG;
    } else if (!pattern.matcher(username).matches()) {
      message = UserProperties.NAME_REGEX_MSG;
    }

    if (message != null) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
      return false;
    }

    return true;
  }
}
