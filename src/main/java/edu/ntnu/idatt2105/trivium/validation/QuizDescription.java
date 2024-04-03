package edu.ntnu.idatt2105.trivium.validation;

import edu.ntnu.idatt2105.trivium.validation.impl.QuizDescriptionValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Annotation for validating quiz descriptions.
 * This annotation is used to mark fields or parameters that represent quiz descriptions,
 * ensuring that they meet specific validation criteria defined by the associated validator.
 */
@Documented
@Constraint(validatedBy = QuizDescriptionValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface QuizDescription {

  /**
   * Specifies the default error message that will be used when the validation fails.
   *
   * @return The default error message.
   */
  String message() default "Invalid description";

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
