package edu.ntnu.idatt2105.trivium.validation;

import edu.ntnu.idatt2105.trivium.validation.impl.TagListValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Annotation for validating tag lists.
 * This annotation is used to mark fields or parameters that represent tag lists,
 * ensuring that they meet specific validation criteria defined by the associated validator.
 */
@Documented
@Constraint(validatedBy = TagListValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TagList {

  /**
   * Specifies the default error message that will be used when the validation fails.
   *
   * @return The default error message.
   */
  String message() default "Invalid tag list";

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
