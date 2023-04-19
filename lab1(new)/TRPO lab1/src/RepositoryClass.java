import java.util.ArrayList;
import java.util.Scanner;

public class RepositoryClass {
    private ArrayList<Student> students = new ArrayList<Student>();
    public ArrayList<Student> getStudents(){
        return  students;
    }
    public void addNewStudent(boolean examPassConfirm, String studentName, String studentGroup, double studentAvgMark, int id){
        students.add(new ScholarshipStudent(studentName,studentGroup,studentAvgMark, id,examPassConfirm));
    }
    public void addNewStudent(double studentEducationCost, String studentName, String studentGroup, double studentAvgMark, int id){
        students.add(new ContractStudent(studentName,studentGroup,studentAvgMark, id,studentEducationCost));
    }

    public void updateStudentInfo(int changeId,boolean examPassConfirm, String studentName, String studentGroup, double studentAvgMark, int id) {
        students.set(changeId, new ScholarshipStudent(studentName, studentGroup, studentAvgMark, id, examPassConfirm));
    }
    public void updateStudentInfo(int changeId,double studentEducationCost, String studentName, String studentGroup, double studentAvgMark, int id) {
        students.set(changeId, new ContractStudent(studentName,studentGroup,studentAvgMark, id,studentEducationCost));
    }
    public void removeStudent(int id){
        students.remove(id);
    }
}
