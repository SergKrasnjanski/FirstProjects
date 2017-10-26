
package serg.basicClasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name="ANSWER")
@Proxy(lazy = false)
public class Answer implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="ANSWER_ID")
    private Integer answerId;
    
    @Column(name="ANSWER")
    private String answer;
    
    @Column(name="RIGHT_ANSWER")
    private boolean rightAns;
    
    @ManyToOne
    @JoinColumn(name="QUESTION_ID")
    private Question question;

    public Answer() {
    }

    public Answer(String answer, boolean rightAns, Question question) {
        this.answer = answer;
        this.rightAns = rightAns;
        this.question = question;
    }

    

    /**
     * @return the answerId
     */
    public Integer getAnswerId() {
        return answerId;
    }

    /**
     * @param answerId the answerId to set
     */
    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
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

    /**
     * @return the rightAna
     */
    public boolean isRightAns() {
        return rightAns;
    }

    /**
     * @param rightAns the rightAns to set
     */
    public void setRightAns(boolean rightAns) {
        this.rightAns = rightAns;
    }

    /**
     * @return the question
     */
    public Question getQuestion() {
        return question;
    }

    /**
     * @param question the question to set
     */
    public void setQuestion(Question question) {
        this.question = question;
    }

}
