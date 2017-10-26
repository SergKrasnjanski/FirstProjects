
package serg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import serg.basicClasses.Answer;
import serg.basicClasses.Question;


public interface AnswerRepository extends JpaRepository<Answer, Integer>{

    public List<Answer> findByQuestion(Question question);
    
}
