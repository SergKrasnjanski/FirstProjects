
package serg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import serg.basicClasses.Test;


public interface TestRepository extends JpaRepository<Test, Integer>{

    public Test findTestByName(String name);
    
}
