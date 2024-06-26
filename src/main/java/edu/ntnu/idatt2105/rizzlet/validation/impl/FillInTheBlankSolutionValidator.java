package edu.ntnu.idatt2105.rizzlet.validation.impl;

import edu.ntnu.idatt2105.rizzlet.properties.QuizProperties;
import edu.ntnu.idatt2105.rizzlet.validation.FillTheBlankSolution;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Validator for the QuestionText constraint.
 * This validator ensures that a question text meets the specified
 * criteria defined in the application properties.
 */
public final class FillInTheBlankSolutionValidator implements ConstraintValidator<FillTheBlankSolution, String> {

  /**
   * Initializes the validator.
   *
   * @param text The FillTheBlankSolution annotation.
   */
  @Override
  public void initialize(FillTheBlankSolution text) {

  }

  /**
   * Validates a text.
   *
   * @param text The text to validate.
   * @param context The constraint validator context.
   * @return true if the text is valid, false otherwise.
   */
  @Override
  public boolean isValid(String text, ConstraintValidatorContext context) {
    String message = null;
    if (text == null) {
      message = QuizProperties.SOLUTION_TEXT_EMPTY;
    } else if (text.length() < QuizProperties.SOLUTION_TEXT_LEN_MIN || text.length() > QuizProperties.SOLUTION_TEXT_LEN_MAX) {
      message = QuizProperties.SOLUTION_TEXT_LEN_MSG;
    }

    if (message != null) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(message).addConstraintViolation();
      return false;
    }

    return true;
  }
}
