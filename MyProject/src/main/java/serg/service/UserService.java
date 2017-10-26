
package serg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import serg.basicClasses.User;
import serg.repository.UserRepository;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    
    public void setUser(User user){
        userRepository.save(user);
    }
    
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    
    public User getUserByLogin(String login){
        return userRepository.findByLogin(login);
    }
    
    public void removeUser(int id){
        userRepository.delete(id);
    }
    
    public void updateResult(String login, double testResult){
        User user = userRepository.findByLogin(login);
        user.setTestResult(testResult);
    }
}
