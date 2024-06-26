package edu.ntnu.idatt2105.rizzlet.model.quiz.library;

import edu.ntnu.idatt2105.rizzlet.model.quiz.Quiz;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Represents a {@link QuizLibrary} entity.
 */
@Data
@AllArgsConstructor
public class QuizLibrary {

  private List<Quiz> created;
  private List<Quiz> coAuthored;

}
