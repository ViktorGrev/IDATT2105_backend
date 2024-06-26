package edu.ntnu.idatt2105.rizzlet.model.quiz.question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Represents a {@link TrueFalseQuestion} entity.
 */
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "true_false_question")
public class TrueFalseQuestion extends Question {

  @Column(name = "is_true", nullable = false)
  private boolean isTrue;

}
