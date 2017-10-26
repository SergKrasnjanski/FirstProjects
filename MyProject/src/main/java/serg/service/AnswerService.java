
package serg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import serg.basicClasses.Answer;
import serg.basicClasses.Question;
import serg.repository.AnswerRepository;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class AnswerService {
    
    @Autowired
    private AnswerRepository answerRepository;
    
    public void setAnswer(Answer answer){
        
        answerRepository.save(answer);
    }
    
    public void removeAnswer(Integer id){
        answerRepository.delete(id);
    }
    
    public void setRightAnswer(Integer id){
        Answer answer = answerRepository.findOne(id);
        answer.setRightAns(true);
    }
    
    public List<Answer> getAnswersByQuestion(Question question){
        return answerRepository.findByQuestion(question);
    }
    
    public List<Answer> getAnswers(){
        return answerRepository.findAll();
    }
    
    public Answer getAnswerById(Integer id){
        return answerRepository.findOne(id);
    }
}
