
package serg.basicClasses;

import java.util.Comparator;

public class UsersComparator implements Comparator<User>{
    public int compare(User a, User b){
        if(a.getUserId()>b.getUserId()){
            return 1;
        }
        else if(a.getUserId()>b.getUserId()){
            return -1;
        }
        else{
            return 0;
        }
    }
}
