package edu.ntnu.idatt2105.trivium.validation;

import edu.ntnu.idatt2105.trivium.validation.impl.QuizTitleValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Annotation for validating quiz titles.
 * This annotation is used to mark fields or parameters that represent quiz titles,
 * ensuring that they meet specific validation criteria defined by the associated validator.
 */
@Documented
@Constraint(validatedBy = QuizTitleValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface QuizTitle {

  /**
   * Specifies the default error message that will be used when the validation fails.
   *
   * @return The default error message.
   */
  String message() default "Invalid title";

  /**
   * Specifies the groups to which this constraint belongs.
   *
   * @return An array of group classes.
   */
  Class<?>[] groups() default {};

  /**
   * Specifies additional metadata about the annotation.
   *
   * @return An array of payload classes.
   */
  Class<? extends Payload>[] payload() default {};

}
