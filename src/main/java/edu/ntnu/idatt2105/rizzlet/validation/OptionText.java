package edu.ntnu.idatt2105.rizzlet.validation;

import edu.ntnu.idatt2105.rizzlet.validation.impl.OptionTextValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Annotation for validating question texts.
 * This annotation is used to mark fields or parameters that represent question texts,
 * ensuring that they meet specific validation criteria defined by the associated validator.
 */
@Documented
@Constraint(validatedBy = OptionTextValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface OptionText {

  /**
   * Specifies the default error message that will be used when the validation fails.
   *
   * @return The default error message.
   */
  String message() default "Invalid question text";

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
