package serg.basicClasses;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="USER")
public class User implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="USER_ID")
    private Integer userId;
    
    @Column(name="NAME")
    private String name;
    
    @Size(min=2, max=20)
    @Column(name="LOGIN")
    private String login;
    
    @Size(min=3, max=20)
    @Column(name="PASSWORD")
    private String password;
    
    @Column(name="TEST_RESULT")
    private double testResult;
    
    public User() {
    }

    public User(Integer userId, String name, String login, String password, double testResult) {
        this.userId = userId;
        this.name = name;
        this.login = login;
        this.password = password;
        this.testResult = testResult;
    }
    
    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the id to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the testResult
     */
    public double getTestResult() {
        return testResult;
    }

    /**
     * @param testResult the testResult to set
     */
    public void setTestResult(double testResult) {
        this.testResult = testResult;
    }
    
    @Override
    public String toString(){
        return "Login = " + getLogin() + ", name = " + getName() + ", password = " + getPassword() + ", testResult = " + getTestResult();
    }
    
    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(!(obj instanceof User)){
            return false;
        }
        User obUser = (User)obj;
        if(getLogin().equals(obUser.getLogin())){
            return true;
        }
        else{
            return false;
        }
    }
}
