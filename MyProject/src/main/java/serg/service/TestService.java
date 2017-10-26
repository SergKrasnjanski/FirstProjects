
package serg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import serg.basicClasses.Test;
import serg.repository.TestRepository;

@Repository
@Transactional(propagation = Propagation.REQUIRED)
public class TestService {
    @Autowired
    private TestRepository testRepository;
    
    public void addTest(Test test){
        testRepository.save(test);
    }
    
    public void removeTest(Integer testId){
        testRepository.delete(testId);
    }
    
    public Test getTestByName(String name){
        return testRepository.findTestByName(name);
    }
    
    public Test getTestById(Integer id){
        return testRepository.findOne(id);
    }
    
    public List<Test> getTests(){
        return testRepository.findAll();
    }
}
