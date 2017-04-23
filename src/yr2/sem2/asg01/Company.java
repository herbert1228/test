package yr2.sem2.asg01;

import java.util.*;

public class Company {

    private HashMap<String, Staff> staffMap = new HashMap<String, Staff>();

    public void addStaff(Staff oneStaff){
        staffMap.put(oneStaff.getStaffID(), oneStaff);
    }

    public void showStaff(){
        for(Object key:staffMap.keySet()){
            System.out.println(staffMap.get(key));
        }
    }

    public Set<String> nameSet(){
        Set<String> names = new HashSet<>();
        for(Object key:staffMap.keySet()){
            names.add(staffMap.get(key).getName());
        }
        return names;
    }

    public List<Integer> salaryList(){
        List<Integer> salaries = new ArrayList<>();
        for(Object key:staffMap.keySet()){
            salaries.add(staffMap.get(key).getSalary());
        }
        return salaries;
    }

    public Staff removeStaff(String staffID){
        Staff staff;
        if ((staff = staffMap.get(staffID)) == null){
            return null;
        }
        staffMap.remove(staffID);
        return staff;
    }
}
