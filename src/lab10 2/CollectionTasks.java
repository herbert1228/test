import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class CollectionTasks {
    public void trySet(){
        Set aSet = new HashSet();
        aSet.add("a set");
        aSet.add(123);
        aSet.add(123);
        Set<String> stringSet = new HashSet<String>();
        stringSet.add("stringSet");
        aSet.add(stringSet);

        System.out.println(aSet);
        System.out.println("no. of elements : "+aSet.size());

        //Iterator it = aSet.iterator();
        //        for (String s : aSet)
        //            System.out.println(s);
        //        }
        for(Object s : aSet){
            System.out.println(s);
        }
    }

    public static void main(String args[]){
        CollectionTasks c = new CollectionTasks();
        c.trySet();
    }

}
