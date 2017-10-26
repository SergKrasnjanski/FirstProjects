
package serg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import serg.basicClasses.Answer;
import serg.basicClasses.Question;
import serg.basicClasses.Test;
import serg.repository.QuestionRepository;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionService {
    
    @Autowired
    private QuestionRepository questionRepository;
    
    public void setQuestion(Question question){
        
        questionRepository.save(question);
    }
    
    public void removeQuestion(Integer questionId){
        questionRepository.delete(questionId);
    }
    
    public void addAnswer(Question question, Answer answer){
        question.getAnswers().add(answer);
    }
    
    public Question getQuestionByName(String name){
        return questionRepository.findByQuestion(name);
    }
    
    public List<Question> getQuestions(){
        return questionRepository.findAll();
    }
    
    public List<Question> getQuestionsByTest(Test test){
        return questionRepository.findByTest(test);
    }
}
