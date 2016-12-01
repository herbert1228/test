import java.util.*;

public class SimpleArray {
    ArrayList<Integer> courseCount = new ArrayList<Integer>(
            Arrays.asList(2,8,3)
    );

    public int findMaximum(){
        int max = -999999;
        for(int i=0; i<courseCount.size(); i++)
            if(courseCount.get(i)>max)
                max = courseCount.get(i);

        return max;
    }

    public double findAverage(){
        double total=0;
        for (double i:courseCount) {
            total+=i;
        }
        return total/courseCount.size();
    }

    public boolean exists(int aCount){
        return courseCount.contains(aCount);
    }
}
