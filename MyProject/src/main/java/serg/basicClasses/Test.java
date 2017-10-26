
package serg.basicClasses;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="TEST")
public class Test implements Serializable{
    
    @Id
    @GeneratedValue
    @Column(name="TEST_ID")
    private Integer testId;
    
    @NotEmpty
    @Column(name="NAME")
    private String name;
    
    @OneToMany(mappedBy="test", cascade=CascadeType.ALL)
    private Set<Question> questions;

    public Test() {
    }

    public Test(Integer testId, String name, Set<Question> questions) {
        this.testId = testId;
        this.name = name;
        this.questions = questions;
    }
    
    /**
     * @return the testId
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * @param testId the testId to set
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the questions
     */
    public Set<Question> getQuestions() {
        return questions;
    }

    /**
     * @param questions the questions to set
     */
    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }
    
    @Override
    public String toString(){
        return "id = " + getTestId() + ", name = " + getName();
    }
 
}
