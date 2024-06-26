package edu.ntnu.idatt2105.rizzlet.dto.quiz.featured;

import edu.ntnu.idatt2105.rizzlet.dto.quiz.QuizDTO;
import lombok.Data;

@Data
public class FeaturedQuizDTO {

  private QuizDTO quiz;
  private double avg_score;
  private long total_results;
  private double popularity_score;

}
