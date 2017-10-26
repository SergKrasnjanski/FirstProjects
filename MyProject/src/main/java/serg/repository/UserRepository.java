
package serg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serg.basicClasses.User;


public interface UserRepository extends JpaRepository<User, Integer>{

    public User findByLogin(String login);

    
}
