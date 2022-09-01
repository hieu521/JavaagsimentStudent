/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StudentAndStudentList;

import ValidateAndIFile.XFile;
import java.io.File;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tltkh
 */
public class StudentList extends Student{
    public ArrayList<Student> list = new ArrayList<>();
    private String path = "D:\\data\\data.txt";
    public void saveToFile() throws Exception{
        XFile.writeObject(path, list);
    }
    
    // load file
    public void loadFromFile() throws Exception{
        File file = new File(path);
        
        if(file.exists()){
            list = (ArrayList<Student>) XFile.readObject(path);
        }else{
            initStudentData();
        }
        
    }
    
    
    // create DataEmployee
     private void initStudentData(){
        list.add(new Student("1","Phong","Phong@gmail.com",1000, 20));
        list.add(new Student("2","Khanh","Khanh@gmail.com",6000, 20));
        list.add(new Student("3","Hieu","Hieu@gmail.com",2000, 20));
    }
    
    private int currentIndex = 0;
    
    public String getCurrentStudentInfo(){
        return "Record" +" "+ (currentIndex +1) +" "+ "of" +" "+ list.size();
    }
    
    public void setCurrentStudent(Student emp){
        currentIndex = list.indexOf(emp);
    }
   
    public int getCurrentStudentIndex(){
        return currentIndex;
    }
//    public Student getCurrentStudent(){
//        if(list.size()==0)
//            return null;
//        return list.get(currentIndex);
//    }
    
    public void add(Student emp){
        list.add(emp);
    }
    
    public boolean update(Student emp){
        Student existedEmp = findByID(emp.getID());
        boolean flag = false;
        if(existedEmp != null){
            existedEmp.setName(emp.getName());
            existedEmp.setAge(emp.getAge());
            existedEmp.setEmail(emp.getEmail());
            existedEmp.setTuition(emp.getTuition());
            
            return true;
        }
        return flag;
    }
    
    public void renderToTable(DefaultTableModel tblModel){
        tblModel.setRowCount(0);
        
        for(Student s : list){
            Object[] row = new Object[]{
                s.getID(), s.getName(),
                s.getAge(), s.getEmail(), s.getTuition()
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    }
    
    // find by ID
    public Student findByID(String employeeId){
        for(Student s : list){
            if(s.getID().equals(employeeId)){
                return s;
            }  
        }
        return null;
    }
    
    //find by Name
    public Student findByName(String employeeName){
        for(Student s : list){
            if(s.getName().equals(employeeName)){
                return s;
            }
        }
        return null;
    }
    
    // delete by Id
    public boolean deleteById(String employeeId){
        for(Student s : list){
            if(s.getID().equals(employeeId)){
                list.remove(s);
                return true;
            } 
        }
        return false;
    }
}
