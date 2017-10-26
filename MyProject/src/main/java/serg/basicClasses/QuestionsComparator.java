package serg.basicClasses;

import java.util.Comparator;

public class QuestionsComparator implements Comparator<Question>{
    public int compare(Question a, Question b){
        if(a.getTest().getTestId()>b.getTest().getTestId()){
            return 1;
        }
        else if(a.getTest().getTestId()<b.getTest().getTestId()){
            return -1;
        }
        else{
            if(a.getQuestionId()>b.getQuestionId()){
                return 1;
            }
            else if(a.getQuestionId()<a.getQuestionId()){
                return -1;
            }
            else{
                return 0;
            }
        }
    }
}
