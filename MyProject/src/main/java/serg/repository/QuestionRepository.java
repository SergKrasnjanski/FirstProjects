
package serg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import serg.basicClasses.Question;
import serg.basicClasses.Test;


public interface QuestionRepository extends JpaRepository<Question, Integer>{

    public Question findByQuestion(String name);

    public List<Question> findByTest(Test test);
    
}
