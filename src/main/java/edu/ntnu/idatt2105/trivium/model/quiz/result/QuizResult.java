package edu.ntnu.idatt2105.trivium.model.quiz.result;

import edu.ntnu.idatt2105.trivium.model.quiz.answer.Answer;
import edu.ntnu.idatt2105.trivium.model.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quiz_result")
public class QuizResult {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Column(name = "score", nullable = false)
  private int score;

  @Column(name = "timestamp", nullable = false)
  private Timestamp timestamp;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "result_id")
  private List<Answer> answers;
}
