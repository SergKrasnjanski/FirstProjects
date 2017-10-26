
package serg.basicClasses;

import java.util.Comparator;

public class TestsComparator implements Comparator<Test>{
    @Override
    public int compare(Test a, Test b){
        if(a.getTestId()>b.getTestId()){
            return 1;
        }
        else if(a.getTestId()<b.getTestId()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
