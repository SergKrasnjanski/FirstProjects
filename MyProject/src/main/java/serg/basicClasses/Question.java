
package serg.basicClasses;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="QUESTION")
@Proxy(lazy = false)
public class Question implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="QUESTION_ID")
    private Integer questionId;
    
    @NotEmpty
    @Column(name="QUESTION")
    private String question;
    
    @ManyToOne
    @JoinColumn(name="TEST_ID")
    private Test test;
    
    transient private String answer;
    
    @OneToMany(mappedBy="question", cascade=CascadeType.ALL)
    private Set<Answer> answers;

    public Question() {
    }

    public Question(Integer questionId, String question, Test test, Set<Answer> answers) {
        this.questionId = questionId;
        this.question = question;
        this.test = test;
        this.answers = answers;
    }

        /**
     * @return the questionId
     */
    public Integer getQuestionId() {
        return questionId;
    }

    /**
     * @param questionId the questionId to set
     */
    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    /**
     * @return the question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(String question) {
        this.question = question;
    }


    /**
     * @return the test
     */
    public Test getTest() {
        return test;
    }

    /**
     * @param test the test to set
     */
    public void setTest(Test test) {
        this.test = test;
    }

    /**
     * @return the answers
     */
    public Set<Answer> getAnswers() {
        return answers;
    }

    /**
     * @param answers the answers to set
     */
    public void setAnswers(Set<Answer> answers) {
        this.answers = answers;
    }
    
    @Override
    public String toString(){
        return "questionId = " + getQuestionId() + ", question = " + getQuestion();
    }
    
    @Override
    public boolean equals(Object obj){
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Question)){
            return false;
        }
        Question obQuestion = (Question)obj;
        if(getQuestionId()==obQuestion.getQuestionId()){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * @return the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer the answer to set
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    
}
